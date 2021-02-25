package com.pdfbox.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentHistory {
    private String payDate;
    private String payCycle;
    private PayPeriod payPeriod;
    private GrossPayAmount grossPayAmount;

}
