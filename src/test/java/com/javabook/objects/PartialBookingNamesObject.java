package com.javabook.objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartialBookingNamesObject {
    private String firstname;
    private String lastname;
}
