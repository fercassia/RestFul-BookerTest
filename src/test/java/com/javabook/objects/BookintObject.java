package com.javabook.objects;

import lombok.*;

@Data
@Builder
public class BookintObject {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesObject bookingdates;
    private String additionalneeds;
}
