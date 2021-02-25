package com.pdfbox.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GrossPayAmount {
    private Double amount;
    private Double rate;
    private Double hour;
    private Double bonuses;
    private Double commission;
    private Double overtime;
    private Double ytdGrossPay;
    private String currencyCode;

}

