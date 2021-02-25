package com.pdfbox.request;

import lombok.Data;

@Data
public class IncomeReport {
    private String reportId;
    private String reportType;
    private String reportGeneratedDate;
    private IncomeRequestor requestor;
    private RespConsumerPii consumerPii;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportGeneratedDate() {
        return reportGeneratedDate;
    }

    public void setReportGeneratedDate(String reportGeneratedDate) {
        this.reportGeneratedDate = reportGeneratedDate;
    }

    public IncomeRequestor getRequestor() {
        return requestor;
    }

    public void setRequestor(IncomeRequestor requestor) {
        this.requestor = requestor;
    }

    public RespConsumerPii getConsumerPii() {
        return consumerPii;
    }

    public void setConsumerPii(RespConsumerPii consumerPii) {
        this.consumerPii = consumerPii;
    }
}
