package com.javabook.tests;

import com.javabook.bases.BaseSetup;
import com.javabook.buildData.BuildBookingData;
import com.javabook.objects.BookingObject;
import com.javabook.token.GenerateToken;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class putBooking extends BaseSetup {

    private BookingObject bookingObject;
    private int bookingId;

    @Test (groups = "Main")
    public void updateBookintTest(){
        //Creating a booking
        BuildBookingData builderBookingData = new BuildBookingData();
       bookingObject = builderBookingData.BookingDataBuilderDepositPaidTrue();

        bookingId = given().body(bookingObject)
                .when()
                .post("/booking")
                .then()
                .extract()
                .path("bookingid");

        given().body(bookingObject)
                .when()
                .header("Cookie", "token="+ GenerateToken.generateValidToken())
                .put("/booking/"+bookingId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .assertThat()
                .body("firstname", equalTo(bookingObject.getFirstname()),
                        "lastname",equalTo(bookingObject.getLastname()),
                        "totalprice",equalTo(bookingObject.getTotalprice()),
                        "depositpaid",equalTo(bookingObject.isDepositpaid()),
                        "bookingdates.checkin",equalTo(bookingObject.getBookingdates().getCheckin()),
                        "bookingdates.checkout",equalTo(bookingObject.getBookingdates().getCheckout()),
                        "additionalneeds",equalTo(bookingObject.getAdditionalneeds()))
                .extract().asString();
    }
}
