package com.javabook.buildData;

import com.github.javafaker.Faker;
import com.javabook.objects.*;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class BuildPartialBookingData {
    public PartialBookingWithoutAdditionalNeedsObject PartialBookingDataBuilderWithoutAddicionalNeeds(){//200 - OK
        Faker faker = Faker.instance();
        SimpleDateFormat formatterDate = new SimpleDateFormat("YYYY-MM-dd");

        return PartialBookingWithoutAdditionalNeedsObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(50,100))
                .depositpaid(true)
                .bookingdates(BookingDatesObject.builder()
                        .checkin(formatterDate.format(faker.date()
                                .past(20, TimeUnit.DAYS)))
                        .checkout(formatterDate.format(faker.date().future(10, TimeUnit.DAYS)))
                        .build())
                .build();
    }
    public PartialBookingNamesAndPriceObject PartialBookingDataBuilderNamesAndPrice (){//400-[POST]Bad request
        Faker faker = Faker.instance();

        return PartialBookingNamesAndPriceObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(1,200))
                .build();
    }
    public PartialBookingWithoutChekoutObject PartialBookingDataBuilderWithoutCheckout (){//400-[POST]Bad request
        Faker faker = Faker.instance();
        SimpleDateFormat formatterDate = new SimpleDateFormat("YYYY-MM-dd");

        return PartialBookingWithoutChekoutObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(50,200))
                .depositpaid(true)
                .bookingdates(BookingDatesChekinObject.builder()
                        .checkin(formatterDate.format(faker.date()
                                .past(20, TimeUnit.DAYS)))
                        .build())
                .additionalneeds("Movie")
                .build();
    }
    public PartialBookingWithoutDatesObject PartialBookingDataBuilderWithoutDates (){//400-[POST]Bad request
        Faker faker = Faker.instance();

        return PartialBookingWithoutDatesObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(50,200))
                .depositpaid(true)
                .additionalneeds("Wine")
                .build();
    }
    public PartialBookingWithoutLastNameObject PartialBookingDataBuilderWithoutLastName(){//400-[POST]Bad request
        Faker faker = Faker.instance();
        SimpleDateFormat formatterDate = new SimpleDateFormat("YYYY-MM-dd");

        return PartialBookingWithoutLastNameObject.builder()
                .firstname(faker.name().firstName())
                .totalprice(faker.number().numberBetween(50,200))
                .depositpaid(true)
                .bookingdates(BookingDatesObject.builder()
                        .checkin(formatterDate.format(faker.date()
                                .past(30, TimeUnit.DAYS)))
                        .checkout(formatterDate.format(faker.date().future(1, TimeUnit.DAYS)))
                        .build())
                .additionalneeds("Diner")
                .build();
    }
    public PartialBookingNamesObject PartialBookingNames (){//400-[POST]Bad request
        Faker faker = Faker.instance();

        return PartialBookingNamesObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .build();
    }
    public PartialBookingAdditionalNeedsObject PartialBookingAdditionalNeeds (){//400-[POST]Bad request
        Faker faker = Faker.instance();

        return PartialBookingAdditionalNeedsObject.builder()
                .additionalneeds(String.valueOf(faker.food()))
                .build();
    }
}
