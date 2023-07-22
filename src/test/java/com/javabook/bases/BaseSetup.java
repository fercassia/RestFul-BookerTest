package com.javabook.bases;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.number.OrderingComparison.lessThan;

public abstract class BaseSetup {

    private String _contetType = "Content-Type";

    private String _accept = "Accept";

    private String _requestResponseModel = "application/json";
    private String _basePath = "https://restful-booker.herokuapp.com";

    @BeforeClass
    public void setup(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(_basePath)
                .addHeader(_contetType, _requestResponseModel)
                .addHeader(_accept, _requestResponseModel)
                .addFilter(new RequestLoggingFilter())//Will log request before it's passed to http builder
                .addFilter(new RequestLoggingFilter())//Will print the response body if response matches a given status cde
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectResponseTime(lessThan(20000L))
                .build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
