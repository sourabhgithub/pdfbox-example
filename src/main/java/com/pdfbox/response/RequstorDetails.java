package com.pdfbox.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequstorDetails {
    @JsonProperty("verifierName")
    private String verifierName;
   @JsonProperty("subscriberCode")
    private String subScriberId;

    public String getVerifierName() {
        return verifierName;
    }

    public void setVerifierName(String verifierName) {
        this.verifierName = verifierName;
    }

    public String getSubScriberId() {
        return subScriberId;
    }

    public void setSubScriberId(String subScriberId) {
        this.subScriberId = subScriberId;
    }
}
