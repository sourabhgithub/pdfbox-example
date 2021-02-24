package com.pdfbox.response;


import lombok.Data;

import java.util.ArrayList;

@Data
public class IncomeAndEmploymentResponse {

    private String reportId;
    private String type;
    private String dataProvider;
    private String reportGeneratedDate;
    private String ssn;
    private ArrayList<EmploymentHistory> employmentHistory;
}
