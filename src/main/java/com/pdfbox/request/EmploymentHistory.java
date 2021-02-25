package com.pdfbox.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmploymentHistory {

    private String originReportId;
    private String originSourceId;

    private String employerIdentificationNumber;
    private String employerName;
    private String originalHireDate;
    private String mostRecentHireDate;
    private EmploymentStatus employmentStatus;
    private WorkStatus workStatus;
    private EmployerAddress employerAddress;
    private List<PaymentHistory> paymentHistory;
    private List<TotalAnnualRenumeration> totalAnnualRenumeration;

    public String getOriginReportId() {
        return originReportId;
    }

    public void setOriginReportId(String originReportId) {
        this.originReportId = originReportId;
    }

    public String getOriginSourceId() {
        return originSourceId;
    }

    public void setOriginSourceId(String originSourceId) {
        this.originSourceId = originSourceId;
    }

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

    public String getOriginalHireDate() {
        return originalHireDate;
    }

    public void setOriginalHireDate(String originalHireDate) {
        this.originalHireDate = originalHireDate;
    }

    public String getMostRecentHireDate() {
        return mostRecentHireDate;
    }

    public void setMostRecentHireDate(String mostRecentHireDate) {
        this.mostRecentHireDate = mostRecentHireDate;
    }

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public EmployerAddress getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(EmployerAddress employerAddress) {
        this.employerAddress = employerAddress;
    }

    public List<PaymentHistory> getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(List<PaymentHistory> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public List<TotalAnnualRenumeration> getTotalAnnualRenumeration() {
        return totalAnnualRenumeration;
    }

    public void setTotalAnnualRenumeration(List<TotalAnnualRenumeration> totalAnnualRenumeration) {
        this.totalAnnualRenumeration = totalAnnualRenumeration;
    }
}
