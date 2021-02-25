package com.pdfbox.request;

import lombok.Data;

import java.util.List;

@Data
public class RespConsumerPii {
    private ApplicantInformation applicantInformation;
    private List<EmploymentHistory> employmentHistory;

}
