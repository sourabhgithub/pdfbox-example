package com.pdfbox.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicantInformation {


    private String lastName;
    private String firstName;
    private String middleName;
    private String generationCode;
    private String name;
    private String address;

    @JsonProperty("currentAddress")
    private EmployeeAddress employeeAddress;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGenerationCode() {
        return generationCode;
    }

    public void setGenerationCode(String generationCode) {
        this.generationCode = generationCode;
    }



    public EmployeeAddress getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(EmployeeAddress employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getName() {
        return firstName+" "+lastName;
    }

    public String getAddress(){
        return employeeAddress.toString();
    }


}
