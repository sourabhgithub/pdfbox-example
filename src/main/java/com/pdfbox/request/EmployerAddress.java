package com.pdfbox.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployerAddress {
    private String lineOne ;
    private String lineTwo;
    private String lineThree;
    private String cityName;
    private String state;
    private String countryCode;
    private String postalCode;

}
