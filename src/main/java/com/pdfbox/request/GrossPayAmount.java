package com.pdfbox.request;

import lombok.Data;

@Data
public class GrossPayAmount {
    private Double amount;
    private String currencyCode;
}
