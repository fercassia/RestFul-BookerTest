package com.javabook.bases;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

import static org.hamcrest.number.OrderingComparison.lessThan;

public abstract class BaseSetup {
    protected String ContetType = "Content-Type";
    protected String Accept = "Accept";
    protected String RequestResponseModel = "application/json";
    protected String BasePath = "https://restful-booker.herokuapp.com";

    @BeforeClass
    public void setup(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BasePath)
                .addHeader(ContetType, RequestResponseModel)
                .addHeader(Accept, RequestResponseModel)
                .addFilter(new RequestLoggingFilter())//Will log request before it's passed to http builder
                .addFilter(new RequestLoggingFilter())//Will print the response body if response matches a given status cde
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectResponseTime(lessThan(20000L))
                .build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
