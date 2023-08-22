package com.javabook.tests;

import com.javabook.bases.BaseSetup;
import com.javabook.buildData.BuildBookingData;
import com.javabook.buildData.BuildPartialBookingData;
import com.javabook.generate.GenerateBooking;
import com.javabook.objects.BookingObject;
import com.javabook.generate.GenerateToken;
import com.javabook.objects.PartialBookingNamesAndPriceObject;
import com.javabook.objects.PartialBookingWithoutAdditionalNeedsObject;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class putBooking extends BaseSetup {
    private BookingObject bookingObject;
    private PartialBookingNamesAndPriceObject partialBookingNamesAndPriceObject;
    private PartialBookingWithoutAdditionalNeedsObject partialBookingWithoutAdditionalNeedsObject;

    @Test (groups = "Main")
    public void updateBookintTestPaidToFalse(){
        //Creating a booking
        int booking = GenerateBooking.generateBookingValid();
        //Updating the booking
        BuildBookingData builderBookingData = new BuildBookingData();
        bookingObject = builderBookingData.BookingDataBuilderDepositPaidFalse();

        //Verify the bookig updated
        given().body(bookingObject)
                .when()
                .header("Cookie", "token="+ GenerateToken.generateValidToken())
                .put("/booking/"+booking)
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
    @Test (groups = "Alternative")
    public void updateBookintTestWithoutAddicionalNeeds(){
        //Creating a booking
        int booking = GenerateBooking.generateBookingValid();

        //Updating the booking
        BuildPartialBookingData builderPartialBookingData = new BuildPartialBookingData();
        partialBookingWithoutAdditionalNeedsObject = builderPartialBookingData.PartialBookingDataBuilderWithoutAddicionalNeeds();

        //Verify the bookig updated
        given().body(partialBookingWithoutAdditionalNeedsObject)
                .when()
                .header("Cookie", "token="+ GenerateToken.generateValidToken())
                .put("/booking/"+booking)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .assertThat()
                .body("firstname", equalTo(partialBookingWithoutAdditionalNeedsObject.getFirstname()),
                        "lastname",equalTo(partialBookingWithoutAdditionalNeedsObject.getLastname()),
                        "totalprice",equalTo(partialBookingWithoutAdditionalNeedsObject.getTotalprice()),
                        "depositpaid",equalTo(partialBookingWithoutAdditionalNeedsObject.isDepositpaid()),
                        "bookingdates.checkin",equalTo(partialBookingWithoutAdditionalNeedsObject.getBookingdates().getCheckin()),
                        "bookingdates.checkout",equalTo(partialBookingWithoutAdditionalNeedsObject.getBookingdates().getCheckout()),
                        "additionalneeds",equalTo(GenerateBooking.bookingObjectGenerated.getAdditionalneeds()))
                .extract().asString();
    }
    @Test (groups = "Exception")
    public void updateErrorBookintTestJustNamesAndPrice(){
        //Creating a booking
        int booking = GenerateBooking.generateBookingValid();

        //Updating the booking
        BuildPartialBookingData builderBookingPartialData = new BuildPartialBookingData();
        partialBookingNamesAndPriceObject = builderBookingPartialData.PartialBookingDataBuilderNamesAndPrice();

        //Verify the bookig updated
        given().body(partialBookingNamesAndPriceObject)
                .when()
                .header("Cookie", "token="+ GenerateToken.generateValidToken())
                .put("/booking/"+booking)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
    @Test (groups = "Exception")
    public void updateErrorAIdNonexistent(){
        //Creating a booking
        int booking = 1;
        //Updating the booking
        BuildBookingData builderBookingData = new BuildBookingData();
        bookingObject = builderBookingData.BookingDataBuilderDepositPaidFalse();

        //Verify the bookig updated
        given().body(bookingObject)
                .when()
                .header("Cookie", "token="+ GenerateToken.generateValidToken())
                .put("/booking/"+booking)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
