package com.pdfbox.request;

import lombok.Data;

@Data
public class PaymentHistory {
    private String payDate;
    private PayPeriod payperiod;
    private GrossPayAmount grossPayAmount;
    private NetPayAmount netPayAmount;

}