package com.javabook.tests;

import com.javabook.bases.BaseSetup;
import com.javabook.generate.GenerateBooking;
import com.javabook.objects.BookingObject;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class getBookingTest extends BaseSetup {
    @Test(groups = "Main")
    public void getBookingsExisting(){
        //Creating A booking to verify the list
        int bookingID = GenerateBooking.generateBookingValid();
        BookingObject bookingInformation = GenerateBooking.bookingObjectGenerated;

        //Verify Bookings ID
        given().get("/booking/"+bookingID)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .and()
                .body("firstname", equalTo(bookingInformation.getFirstname()),
                        "lastname",equalTo(bookingInformation.getLastname()),
                        "totalprice",equalTo(bookingInformation.getTotalprice()),
                        "depositpaid",equalTo(bookingInformation.isDepositpaid()),
                        "bookingdates.checkin",equalTo(bookingInformation.getBookingdates().getCheckin()),
                        "bookingdates.checkout",equalTo(bookingInformation.getBookingdates().getCheckout()),
                        "additionalneeds",equalTo(bookingInformation.getAdditionalneeds()))
                .extract().asString();
    }
    @Test(groups = "Exception")
    public void getBookingsInvalidReturningError(){
        //Creating A booking to verify the list
        int bookingID = 0;

        //Verify Bookings ID
        given().get("/booking/"+bookingID)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
