package com.pdfbox.request;

import lombok.Data;

@Data
public class Name {
    private String lastName;
    private String firstName;
    private String middleName;
    private String generationCode;
}
