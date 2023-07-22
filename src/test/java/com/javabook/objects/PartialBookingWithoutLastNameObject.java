package com.javabook.objects;

import lombok.*;

@Data
@Builder
public class PartialBookingWithoutLastNameObject {
    private String firstname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesObject bookingdates;
    private String additionalneeds;
}
