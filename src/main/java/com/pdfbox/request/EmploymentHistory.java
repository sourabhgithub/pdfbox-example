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

}
