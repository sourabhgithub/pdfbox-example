package com.pdfbox.request;

import lombok.Data;

@Data
public class TotalAnnualRenumeration {

    private int year;
    private Double amount;
    private String currencyCode;

}
