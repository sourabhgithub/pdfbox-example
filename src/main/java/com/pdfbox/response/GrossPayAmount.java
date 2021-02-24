package com.pdfbox.response;

import lombok.Data;

@Data
public class GrossPayAmount {
    private Double amount;
    private String currencyCode;
}
