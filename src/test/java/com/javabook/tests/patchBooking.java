package com.javabook.tests;

import com.javabook.bases.BaseSetup;
import com.javabook.buildData.BuildPartialBookingData;
import com.javabook.generate.GenerateBooking;
import com.javabook.generate.GenerateToken;
import com.javabook.objects.*;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class patchBooking extends BaseSetup {
    private PartialBookingNamesAndPriceObject partialBookingNamesAndPriceObject;
    private PartialBookingNamesObject partialBookingNamesObject;
    private PartialBookingAdditionalNeedsObject partialBookingAdditionalNeedsObject;

    @Test(groups = "Main")
    public void patchBookintTestJustNameAndPrice(){
        //Creating a booking
        int bookingID = GenerateBooking.generateBookingValid();
        BookingObject bookingInformation = GenerateBooking.bookingObjectGenerated;

        //Updating the booking
        BuildPartialBookingData builderBookingPartialData = new BuildPartialBookingData();
        partialBookingNamesAndPriceObject = builderBookingPartialData.PartialBookingDataBuilderNamesAndPrice();

        //Verify the bookig updated
        given().body(partialBookingNamesAndPriceObject)
                .when()
                .header("Cookie", "token="+ GenerateToken.generateValidToken())
                .patch("/booking/"+bookingID)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .assertThat()
                .body("firstname", equalTo(partialBookingNamesAndPriceObject.getFirstname()),
                        "lastname",equalTo(partialBookingNamesAndPriceObject.getLastname()),
                        "totalprice",equalTo(partialBookingNamesAndPriceObject.getTotalprice()),
                        "depositpaid",equalTo(bookingInformation.isDepositpaid()),
                        "bookingdates.checkin",equalTo(bookingInformation.getBookingdates().getCheckin()),
                        "bookingdates.checkout",equalTo(bookingInformation.getBookingdates().getCheckout()),
                        "additionalneeds",equalTo(bookingInformation.getAdditionalneeds()))
                .extract().asString();
    }
    @Test(groups = "Alternative")
    public void patchBookintTestJustName(){
        //Creating a booking
        int bookingID = GenerateBooking.generateBookingValid();
        BookingObject bookingInformation = GenerateBooking.bookingObjectGenerated;

        //Updating the booking
        BuildPartialBookingData builderBookingPartialData = new BuildPartialBookingData();
        partialBookingNamesObject = builderBookingPartialData.PartialBookingNames();

        //Verify the bookig updated
        given().body(partialBookingNamesObject)
                .when()
                .header("Cookie", "token="+ GenerateToken.generateValidToken())
                .patch("/booking/"+bookingID)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .assertThat()
                .body("firstname", equalTo(partialBookingNamesObject.getFirstname()),
                        "lastname",equalTo(partialBookingNamesObject.getLastname()),
                        "totalprice",equalTo(bookingInformation.getTotalprice()),
                        "depositpaid",equalTo(bookingInformation.isDepositpaid()),
                        "bookingdates.checkin",equalTo(bookingInformation.getBookingdates().getCheckin()),
                        "bookingdates.checkout",equalTo(bookingInformation.getBookingdates().getCheckout()),
                        "additionalneeds",equalTo(bookingInformation.getAdditionalneeds()))
                .extract().asString();
    }
    @Test(groups = "Alternative")
    public void patchBookintTestJustAdditionalNeeds(){
        //Creating a booking
        int bookingID = GenerateBooking.generateBookingValid();
        BookingObject bookingInformation = GenerateBooking.bookingObjectGenerated;

        //Updating the booking
        BuildPartialBookingData builderBookingPartialData = new BuildPartialBookingData();
        partialBookingAdditionalNeedsObject = builderBookingPartialData.PartialBookingAdditionalNeeds();

        //Verify the bookig updated
        given().body(partialBookingAdditionalNeedsObject)
                .when()
                .header("Cookie", "token="+ GenerateToken.generateValidToken())
                .patch("/booking/"+bookingID)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .assertThat()
                .body("firstname", equalTo(bookingInformation.getFirstname()),
                        "lastname",equalTo(bookingInformation.getLastname()),
                        "totalprice",equalTo(bookingInformation.getTotalprice()),
                        "depositpaid",equalTo(bookingInformation.isDepositpaid()),
                        "bookingdates.checkin",equalTo(bookingInformation.getBookingdates().getCheckin()),
                        "bookingdates.checkout",equalTo(bookingInformation.getBookingdates().getCheckout()),
                        "additionalneeds",equalTo(partialBookingAdditionalNeedsObject.getAdditionalneeds()))
                .extract().asString();
    }
    @Test(groups = "Exception")
    public void updatingBookintTestJustAdditionalNeedsWithWrongHttpMethod(){
        //Creating a booking
        int bookingID = GenerateBooking.generateBookingValid();

        //Updating the booking
        BuildPartialBookingData builderBookingPartialData = new BuildPartialBookingData();
        partialBookingAdditionalNeedsObject = builderBookingPartialData.PartialBookingAdditionalNeeds();

        //Verify the bookig updated
        given().body(partialBookingAdditionalNeedsObject)
                .when()
                .header("Cookie", "token="+ GenerateToken.generateValidToken())
                .put("/booking/"+bookingID)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
    @Test(groups = "Exception")
    public void patchBookintTestJustAdditionalNeedsWithWrongID(){
        //Creating a booking
        int bookingID = 1;

        //Updating the booking
        BuildPartialBookingData builderBookingPartialData = new BuildPartialBookingData();
        partialBookingAdditionalNeedsObject = builderBookingPartialData.PartialBookingAdditionalNeeds();

        //Verify the bookig updated
        given().body(partialBookingAdditionalNeedsObject)
                .when()
                .header("Cookie", "token="+ GenerateToken.generateValidToken())
                .put("/booking/"+bookingID)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
