package com.javabook.generate;

import com.javabook.bases.BaseSetup;
import com.javabook.buildData.BuildTokenData;
import com.javabook.objects.TokenObject;

import static io.restassured.RestAssured.*;

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
