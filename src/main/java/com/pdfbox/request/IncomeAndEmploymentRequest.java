package com.pdfbox.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomeAndEmploymentRequest {

    private IncomeReport incomeReport;

    public IncomeReport getIncomeReport() {
        return incomeReport;
    }

    public void setIncomeReport(IncomeReport incomeReport) {
        this.incomeReport = incomeReport;
    }
}
