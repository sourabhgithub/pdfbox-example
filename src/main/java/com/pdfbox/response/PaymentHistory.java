package com.pdfbox.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentHistory {
    private String payDate;
    private PayPeriod payperiod;
    private GrossPayAmount grossPayAmount;
    private NetPayAmount netPayAmount;

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public PayPeriod getPayperiod() {
        return payperiod;
    }

    public void setPayperiod(PayPeriod payperiod) {
        this.payperiod = payperiod;
    }

    public GrossPayAmount getGrossPayAmount() {
        return grossPayAmount;
    }

    public void setGrossPayAmount(GrossPayAmount grossPayAmount) {
        this.grossPayAmount = grossPayAmount;
    }

    public NetPayAmount getNetPayAmount() {
        return netPayAmount;
    }

    public void setNetPayAmount(NetPayAmount netPayAmount) {
        this.netPayAmount = netPayAmount;
    }
}
