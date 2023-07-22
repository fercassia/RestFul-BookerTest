package com.javabook.objects;
import lombok.*;

@Data
@Builder
public class PartialBookingNamesAndPriceObject {
    private String firstname;
    private String lastname;
    private int totalprice;
}
