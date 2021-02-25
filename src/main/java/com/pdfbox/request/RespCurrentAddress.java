package com.pdfbox.request;

import lombok.Data;

@Data
public class RespCurrentAddress {

    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String state;
    private String zipCode;
}
