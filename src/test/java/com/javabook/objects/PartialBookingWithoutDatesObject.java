package com.javabook.objects;
import lombok.*;

@Data
@Builder
public class PartialBookingWithoutDatesObject {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additionalneeds;
}
