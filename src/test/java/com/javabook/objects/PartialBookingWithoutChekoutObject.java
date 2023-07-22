package com.javabook.objects;
import lombok.*;

@Data
@Builder
public class PartialBookingWithoutChekoutObject {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesChekinObject bookingdates;
    private String additionalneeds;
}
