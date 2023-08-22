package com.javabook.tests;

import com.javabook.bases.BaseSetup;
import com.javabook.generate.GenerateBooking;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class getBookingIdsTest extends BaseSetup {
    @Test(groups = "Main")
    public void getBookingsExisting(){
        //Creating A booking to verify the list
        int bookingID = GenerateBooking.generateBookingValid();

        //Verify Bookings ID
        given().get("/booking")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .assertThat()
                .body("bookingid",hasItem(bookingID));
    }
}
