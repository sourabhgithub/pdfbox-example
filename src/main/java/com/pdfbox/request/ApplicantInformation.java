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

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Ssn getSsn() {
        return ssn;
    }

    public void setSsn(Ssn ssn) {
        this.ssn = ssn;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public List<RespPhone> getPhone() {
        return phone;
    }

    public void setPhone(List<RespPhone> phone) {
        this.phone = phone;
    }

    public RespCurrentAddress getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(RespCurrentAddress currentAddress) {
        this.currentAddress = currentAddress;
    }
}
