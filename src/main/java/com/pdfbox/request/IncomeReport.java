package com.pdfbox.request;

import lombok.Data;

@Data
public class IncomeReport {
    private String reportId;
    private String reportType;
    private String reportGeneratedDate;
    private IncomeRequestor requestor;
    private RespConsumerPii consumerPii;

}
