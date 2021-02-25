package com.pdfbox.request;

import lombok.Data;

import java.util.List;

@Data
public class RespConsumerPii {
    private ApplicantInformation applicantInformation;
    private List<EmploymentHistory> employmentHistory;

    public ApplicantInformation getApplicantInformation() {
        return applicantInformation;
    }

    public void setApplicantInformation(ApplicantInformation applicantInformation) {
        this.applicantInformation = applicantInformation;
    }

    public List<EmploymentHistory> getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(List<EmploymentHistory> employmentHistory) {
        this.employmentHistory = employmentHistory;
    }
}
