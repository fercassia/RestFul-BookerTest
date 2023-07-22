package com.javabook.tests;

import com.javabook.bases.BaseSetup;
import com.javabook.buildData.BuildBookingData;
import com.javabook.buildData.BuildPartialBookingData;
import com.javabook.objects.*;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class postBokingTest extends BaseSetup {

    private BookingObject bookingObject;
    private PartialBookingNamesAndPriceObject partialBookingNamesAndPriceObject;
    private PartialBookingWithoutChekoutObject partialBookingWithoutChekoutObject;
    private PartialBookingWithoutDatesObject partialBookingWithoutDatesObject;
    private PartialBookingWithoutLastNameObject partialBookingWithoutLastNameObject;

    @Test(groups = "main")
    public void creatingBookingDepositPaidTrueTest(){
        BuildBookingData builderBookingData = new BuildBookingData();
        bookingObject = builderBookingData.BookingDataBuilderDepositPaidTrue();

        int bookingId = given().body(bookingObject)
                .when()
                .post("/booking")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("bookingid", notNullValue(Integer.class))
                .body("booking. firstname",equalTo(bookingObject.getFirstname()))
                .body("booking.lastname",equalTo(bookingObject.getLastname()))
                .body("booking.totalprice",equalTo(bookingObject.getTotalprice()))
                .body("booking.depositpaid",equalTo(bookingObject.isDepositpaid()))
                .body("booking.bookingdates.checkin",equalTo(bookingObject.getBookingdates().getCheckin()))
                .body("booking.bookingdates.checkout",equalTo(bookingObject.getBookingdates().getCheckout()))
                .body("booking.additionalneeds",equalTo(bookingObject.getAdditionalneeds()))
                .extract()
                .path("bookingid");
    }
    @Test(groups = "alternative")
    public void creatingBookingDepositPaidFalseTest(){
        BuildBookingData builderBookingData = new BuildBookingData();
        bookingObject = builderBookingData.BookingDataBuilderDepositPaidFalse();

        int bookingId = given().body(bookingObject)
                .when()
                .post("/booking")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("bookingid", notNullValue())
                .body("booking. firstname",equalTo(bookingObject.getFirstname()))
                .body("booking.lastname",equalTo(bookingObject.getLastname()))
                .body("booking.totalprice",equalTo(bookingObject.getTotalprice()))
                .body("booking.depositpaid",equalTo(bookingObject.isDepositpaid()))
                .body("booking.bookingdates.checkin",equalTo(bookingObject.getBookingdates().getCheckin()))
                .body("booking.bookingdates.checkout",equalTo(bookingObject.getBookingdates().getCheckout()))
                .body("booking.additionalneeds",equalTo(bookingObject.getAdditionalneeds()))
                .extract()
                .path("bookingid");
    }
    @Test(groups = "exception")
    public void creatingBookingNamesAndPrice(){
        BuildPartialBookingData builderPartialBookingData = new BuildPartialBookingData();
        partialBookingNamesAndPriceObject = builderPartialBookingData.PartialBookingDataBuilderNamesAndPrice();

        int bookingId = given().body(partialBookingNamesAndPriceObject)
                .when()
                .post("/booking")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .path("bookingid");
    }
    @Test(groups = "exception")
    public void creatingBookingWithoutDates(){
        BuildPartialBookingData builderPartialBookingData = new BuildPartialBookingData();
        partialBookingWithoutDatesObject = builderPartialBookingData.PartialBookingDataBuilderWithoutDates();

        int bookingId = given().body(partialBookingWithoutDatesObject)
                .when()
                .post("/booking")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .path("bookingid");
    }

    @Test(groups = "exception")
    public void creatingBookingWithoutCheckout(){
        BuildPartialBookingData builderPartialBookingData = new BuildPartialBookingData();
        partialBookingWithoutChekoutObject = builderPartialBookingData.PartialBookingDataBuilderWithoutCheckout();

        int bookingId = given().body(partialBookingWithoutChekoutObject)
                .when()
                .post("/booking")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .path("bookingid");
    }
    @Test(groups = "exception")
    public void creatingBookingWithoutLastName(){
        BuildPartialBookingData builderPartialBookingData = new BuildPartialBookingData();
        partialBookingWithoutLastNameObject = builderPartialBookingData.PartialBookingDataBuilderWithoutLastName();

        int bookingId = given().body(partialBookingWithoutLastNameObject)
                .when()
                .post("/booking")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .path("bookingid");
    }
}
