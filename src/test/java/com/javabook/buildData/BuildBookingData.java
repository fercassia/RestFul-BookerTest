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
                .totalprice(faker.number().numberBetween(50,200))
                .depositpaid(true)
                .bookingdates(BookingDatesObject.builder()
                        .checkin(formatterDate.format(faker.date()
                                .past(20, TimeUnit.DAYS)))
                        .checkout(formatterDate.format(faker.date().future(5, TimeUnit.DAYS)))
                        .build())
                .additionalneeds("Breakfast")
                .build();
    }
    public BookingObject BookingDataBuilderDepositPaidFalse (){ //200 - OK
        Faker faker = Faker.instance();
        SimpleDateFormat formatterDate = new SimpleDateFormat("YYYY-MM-dd");

        return BookingObject.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(50,200))
                .depositpaid(false)
                .bookingdates(BookingDatesObject.builder()
                        .checkin(formatterDate.format(faker.date()
                                .past(30, TimeUnit.DAYS)))
                        .checkout(formatterDate.format(faker.date().future(1, TimeUnit.DAYS)))
                        .build())
                .additionalneeds("Wine and Pizza")
                .build();
    }
}
