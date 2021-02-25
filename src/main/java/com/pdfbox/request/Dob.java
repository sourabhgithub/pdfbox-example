package com.pdfbox.request;

import lombok.Data;

@Data
public class Dob {
    private String dob;

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
