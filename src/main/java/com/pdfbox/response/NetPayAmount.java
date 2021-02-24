package com.pdfbox.response;

import lombok.Data;

@Data
public class NetPayAmount {
    private Double amount;
    private String currencyCode;

}
