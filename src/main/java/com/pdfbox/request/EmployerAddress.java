package com.pdfbox.request;

import lombok.Data;

@Data
public class EmployerAddress {
    private String lineOne;
    private String lineTwo;
    private String lineThree;
    private String cityName;
    private SubdivisionCode1 subdivisionCode1;
    private String countryCode;
    private String postalCode;



}
