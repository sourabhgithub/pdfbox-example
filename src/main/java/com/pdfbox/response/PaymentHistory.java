package com.pdfbox.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentHistory {
    private String payDate;
    private String payCycle;
    @JsonProperty("payPeriod")
    private PayPeriod payperiod;
    private GrossPayAmount grossPayAmount;
    private NetPayAmount netPayAmount;

    public String getPayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("mmDDyyyy");
        if(payDate !=null){
            try {
                Date payDate = sdf.parse(getPayDate());
                SimpleDateFormat sdf2 = new SimpleDateFormat("mm/DD/yyyy");
                return sdf2.format(payDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return "no Data";
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

    public String getPayCycle() {
        return payCycle;
    }

    public void setPayCycle(String payCycle) {
        this.payCycle = payCycle;
    }
}
