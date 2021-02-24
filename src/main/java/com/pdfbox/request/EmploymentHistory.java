package com.pdfbox.request;

import lombok.Data;

import java.util.ArrayList;

@Data
public class EmploymentHistory {

    private String employerIdentificationNumber;
    private String employerName;
    private EmployerAddress employerAddress;
    private EmploymentStatus employmentStatus;
    private EmploymentType employmentType;
    private ArrayList<PaymentHistory> paymentHistory;

}
