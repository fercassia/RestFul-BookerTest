package com.javabook.objects;

import lombok.*;

@Data
@Builder
public class TokenObject {
    private String username;
    private String password;
}
