package com.pdfbox.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeAddress {
    @JsonProperty("line1")
    private String lineOne ="";
    @JsonProperty("line2")
    private String lineTwo ="";
    @JsonProperty("line3")
    private String lineThree="";
    @JsonProperty("city")
    private String cityName="";
    private SubdivisionCode1 subdivisionCode1;
    private String countryCode="";
    private String stateCode="";
    @JsonProperty("zipCode")
    private String postalCode="";

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }

    public String getLineThree() {
        return lineThree;
    }

    public void setLineThree(String lineThree) {
        this.lineThree = lineThree;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public SubdivisionCode1 getSubdivisionCode1() {
        return subdivisionCode1;
    }

    public void setSubdivisionCode1(SubdivisionCode1 subdivisionCode1) {
        this.subdivisionCode1 = subdivisionCode1;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        String returnStr ="";
        if(lineOne!=null && !lineOne.isEmpty())
            returnStr+=lineOne+", ";
        if(lineTwo!=null && !lineTwo.isEmpty())
            returnStr+=lineTwo+", ";
        if(lineThree!=null && !lineThree.isEmpty())
            returnStr+=lineThree+", ";
        if(cityName!=null && !cityName.isEmpty())
            returnStr+=cityName+", ";
        if(countryCode!=null && !countryCode.isEmpty())
            returnStr+=countryCode+", ";
        if(postalCode!=null && !postalCode.isEmpty())
            returnStr+=postalCode;

        return returnStr;

    }
}
