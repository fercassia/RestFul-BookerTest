package com.javabook.bases;

import com.javabook.GlobalParameters;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.number.OrderingComparison.lessThan;

public abstract class BaseStup {

    private String _contetType = "Content-Type";

    private String _accept = "Accept";

    @BeforeClass
    public void setup(){
        RequestSpecification requestSpecification =new RequestSpecBuilder()
                .setBaseUri(GlobalParameters.URI_DEFAUL)
                .addHeader(_contetType,  GlobalParameters.REQUEST_RESPONSE_MODEL)
                .addHeader(_accept,GlobalParameters.REQUEST_RESPONSE_MODEL)
                .addFilter(new RequestLoggingFilter())//Will log request before it's passed to http builder
                .addFilter(new RequestLoggingFilter())//Will print the response body if response matches a given status cde
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectResponseTime(lessThan(20000L))
                .build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
