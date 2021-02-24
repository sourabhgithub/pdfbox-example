package com.pdfbox.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomeAndEmploymentResponse {

    private String reportId;
    @JsonProperty("reportType")
    private String type;

    private String dataProvider;
    private String reportGeneratedDate;
    private String ssn;
    private String dob;
    ApplicantInformation applicantInformation;
    @JsonProperty("requestor")
    private RequstorDetails requestor = new RequstorDetails();
    private ArrayList<EmploymentHistory> employmentHistory = new ArrayList<>();

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(String dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String getReportGeneratedDate() {
        return reportGeneratedDate;
    }

    public void setReportGeneratedDate(String reportGeneratedDate) {
        this.reportGeneratedDate = reportGeneratedDate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public ArrayList<EmploymentHistory> getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(ArrayList<EmploymentHistory> employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public ApplicantInformation getApplicantInformation() {
        return applicantInformation;
    }

    public void setApplicantInformation(ApplicantInformation applicantInformation) {
        this.applicantInformation = applicantInformation;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public RequstorDetails getRequestor() {
        return requestor;
    }

    public void setRequestor(RequstorDetails requestor) {
        this.requestor = requestor;
    }

}
