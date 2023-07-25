package com.javabook.token;

import com.javabook.bases.BaseSetup;
import com.javabook.buildData.BuildTokenData;
import com.javabook.objects.TokenObject;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class GenerateToken extends BaseSetup {

    public static String generateValidToken(){
        BuildTokenData builderToken = new BuildTokenData();
        TokenObject tokenObject = builderToken.GenerateValidToken();

        return given().body(tokenObject)
                .when()
                .post("/auth")
                .then()
                .extract()
                .path("token");
    }
}
