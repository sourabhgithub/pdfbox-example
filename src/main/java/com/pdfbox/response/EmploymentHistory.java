package com.pdfbox.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmploymentHistory {

    private String employerIdentificationNumber;
    private String employerName;
    private String originalHireDate;
    private EmployerAddress employerAddress;
    private EmploymentStatus employmentStatus;
    @JsonProperty("workStatus")
    private EmploymentType employmentType;
    private ArrayList<PaymentHistory> paymentHistory;

    public String getEmployerIdentificationNumber() {
        return employerIdentificationNumber;
    }

    public void setEmployerIdentificationNumber(String employerIdentificationNumber) {
        this.employerIdentificationNumber = employerIdentificationNumber;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public EmployerAddress getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(EmployerAddress employerAddress) {
        this.employerAddress = employerAddress;
    }

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public ArrayList<PaymentHistory> getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(ArrayList<PaymentHistory> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }
    public String getOriginalHireDate() {
        return originalHireDate;
    }

    public void setOriginalHireDate(String originalHireDate) {
        this.originalHireDate = originalHireDate;
    }
}
