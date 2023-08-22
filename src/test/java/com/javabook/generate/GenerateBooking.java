package com.javabook.generate;

import com.javabook.bases.BaseSetup;
import com.javabook.buildData.BuildBookingData;
import com.javabook.objects.BookingObject;

import static io.restassured.RestAssured.given;

public class GenerateBooking extends BaseSetup {
    public static BookingObject bookingObjectGenerated;

    public static Integer generateBookingValid(){
        BuildBookingData buildBookingData = new BuildBookingData();
        bookingObjectGenerated = buildBookingData.BookingDataBuilderDepositPaidTrue();

        return given().body(bookingObjectGenerated)
                .when()
                .post("/booking")
                .then()
                .extract()
                .path("bookingid");
    }
}
