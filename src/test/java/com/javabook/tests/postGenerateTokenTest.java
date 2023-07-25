package com.javabook.tests;

import com.javabook.bases.BaseSetup;
import com.javabook.buildData.BuildTokenData;
import com.javabook.objects.TokenObject;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class postGenerateTokenTest extends BaseSetup {

    @Test(groups = "main")
    public static String generateValidToken(){
        BuildTokenData builderToken = new BuildTokenData();
        TokenObject tokenObject = builderToken.GenerateValidToken();

        return given().body(tokenObject)
                .when()
                .post("/auth")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .assertThat()
                .body("token", not(nullValue()))
                .extract()
                .path("token");
    }
}
