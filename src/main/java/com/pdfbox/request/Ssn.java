package com.pdfbox.request;

import lombok.Data;

@Data
public class Ssn {
    private String ssn;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
