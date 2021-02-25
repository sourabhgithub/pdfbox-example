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

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayCycle() {
        return payCycle;
    }

    public void setPayCycle(String payCycle) {
        this.payCycle = payCycle;
    }

    public PayPeriod getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(PayPeriod payPeriod) {
        this.payPeriod = payPeriod;
    }

    public GrossPayAmount getGrossPayAmount() {
        return grossPayAmount;
    }

    public void setGrossPayAmount(GrossPayAmount grossPayAmount) {
        this.grossPayAmount = grossPayAmount;
    }
}
