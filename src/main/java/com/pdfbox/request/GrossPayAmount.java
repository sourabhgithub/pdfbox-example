package com.pdfbox.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GrossPayAmount {
    private Double amount;
    private Double rate;
    private Double hour;
    private Double bonuses;
    private Double commission;
    private Double overtime;
    private Double ytdGrossPay;
    private String currencyCode;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }

    public Double getBonuses() {
        return bonuses;
    }

    public void setBonuses(Double bonuses) {
        this.bonuses = bonuses;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getOvertime() {
        return overtime;
    }

    public void setOvertime(Double overtime) {
        this.overtime = overtime;
    }

    public Double getYtdGrossPay() {
        return ytdGrossPay;
    }

    public void setYtdGrossPay(Double ytdGrossPay) {
        this.ytdGrossPay = ytdGrossPay;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}

