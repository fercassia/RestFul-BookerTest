package com.javabook.objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartialBookingWithoutAdditionalNeedsObject {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesObject bookingdates;
}
