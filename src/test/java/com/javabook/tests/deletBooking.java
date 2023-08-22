package com.javabook.tests;

import com.javabook.bases.BaseSetup;
import com.javabook.generate.GenerateBooking;
import com.javabook.generate.GenerateToken;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deletBooking extends BaseSetup {
    //Creating a booking
    @Test(groups = "Main")
    public void deletBookintWithSuccess(){
        //Creating a booking
        int bookingID = GenerateBooking.generateBookingValid();

        //Verify Deleting A Book
        given().header("Cookie", "token="+ GenerateToken.generateValidToken())
                .delete("/booking/"+bookingID)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test(groups = "Alternative")
    public void deletBookintThatNotExist(){
        int idBookingNotAvailable = 0;
        //Verify Deleting A Book
        given().header("Cookie", "token="+ GenerateToken.generateValidToken())
                .delete("/booking/"+idBookingNotAvailable)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
