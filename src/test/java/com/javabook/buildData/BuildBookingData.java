package com.javabook.buildData;

import com.github.javafaker.Faker;
import com.javabook.objects.*;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class BuildBookingData {
    public BookingObject BookingDataBuilderDepositPaidTrue (){ //200 - OK
        Faker faker = Faker.instance();
        SimpleDateFormat formatterDate = new SimpleDateFormat("YYYY-MM-dd");

        return BookingObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(1,200))
                .depositpaid(true)
                .bookingdates(BookingDatesObject.builder()
                        .checkin(formatterDate.format(faker.date()
                                .past(20, TimeUnit.DAYS)))
                        .checkout(formatterDate.format(faker.date().future(5, TimeUnit.DAYS)))
                        .build())
                .additionalneeds("Girls Love")
                .build();
    }
    public BookingObject BookingDataBuilderDepositPaidFalse (){ //200 - OK
        Faker faker = Faker.instance();
        SimpleDateFormat formatterDate = new SimpleDateFormat("YYYY-MM-dd");

        return BookingObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(1,200))
                .depositpaid(false)
                .bookingdates(BookingDatesObject.builder()
                        .checkin(formatterDate.format(faker.date()
                                .past(30, TimeUnit.DAYS)))
                        .checkout(formatterDate.format(faker.date().future(1, TimeUnit.DAYS)))
                        .build())
                .additionalneeds("Boys Love")
                .build();
    }
    public BookingObject BookingDataBuilderDepositDatesDifferentFormat (){ //200 - OK
        Faker faker = Faker.instance();
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-YYYY");

        return BookingObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(1,200))
                .depositpaid(true)
                .bookingdates(BookingDatesObject.builder()
                        .checkin(formatterDate.format(faker.date()
                                .past(20, TimeUnit.DAYS)))
                        .checkout(formatterDate.format(faker.date().future(5, TimeUnit.DAYS)))
                        .build())
                .additionalneeds("Bellow her mouth")
                .build();
    }
    public PartialBookingWithoutChekoutObject BookingDataBuilderWithoutCheckout (){ //400 - Bad Request
        Faker faker = Faker.instance();
        SimpleDateFormat formatterDate = new SimpleDateFormat("YYYY-MM-dd");

        return PartialBookingWithoutChekoutObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(1,200))
                .depositpaid(true)
                .bookingdates(BookingDatesChekinObject.builder()
                        .checkin(formatterDate.format(faker.date()
                                .past(20, TimeUnit.DAYS)))
                        .build())
                .additionalneeds("Dexter")
                .build();
    }
    public PartialBookingWithoutDatesObject PartialBookingDataBuilderWithoutDates (){ //400 - Bad request
        Faker faker = Faker.instance();

        return PartialBookingWithoutDatesObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(1,200))
                .depositpaid(true)
                .additionalneeds("Imagine me and you")
                .build();
    }
    public PartialBookingNamesAndPriceObject PartialBookingDataBuilderNamesAndPrice (){ //400 - Bad request
        Faker faker = Faker.instance();

        return PartialBookingNamesAndPriceObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(1,200))
                .build();
    }

}
