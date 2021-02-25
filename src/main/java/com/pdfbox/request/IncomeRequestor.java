package com.pdfbox.request;

import lombok.Data;

@Data
public class IncomeRequestor {
    private String subscriberCode;
    private String verifierName;

    public String getSubscriberCode() {
        return subscriberCode;
    }

    public void setSubscriberCode(String subscriberCode) {
        this.subscriberCode = subscriberCode;
    }

    public String getVerifierName() {
        return verifierName;
    }

    public void setVerifierName(String verifierName) {
        this.verifierName = verifierName;
    }
}
