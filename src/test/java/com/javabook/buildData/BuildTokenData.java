package com.javabook.buildData;
import com.javabook.objects.TokenObject;

public class BuildTokenData{

    public TokenObject GenerateValidToken(){
        return TokenObject.builder()
                .username("admin")
                .password("password123")
                .build();
    }

}
