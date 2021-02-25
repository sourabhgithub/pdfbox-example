package com.pdfbox.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicantInformation {

    private Name name;
    private Ssn ssn;
    private Dob dob;
    private List<RespPhone> phone;
    private RespCurrentAddress currentAddress;


}
