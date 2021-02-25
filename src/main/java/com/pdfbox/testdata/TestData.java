package com.pdfbox.testdata;

import com.pdfbox.request.*;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static IncomeAndEmploymentRequest getIncomeAndEmploymentRequest() {

        IncomeAndEmploymentRequest incomeAndEmploymentRequest = new IncomeAndEmploymentRequest();
        incomeAndEmploymentRequest.setIncomeReport(getIncomeReport());

        return incomeAndEmploymentRequest;

    }

    private static IncomeReport getIncomeReport() {
        IncomeReport incomeReport = new IncomeReport();
        incomeReport.setReportId("a216e0ee-7709-11eb-9439-0242ac130002");
        incomeReport.setReportType("ReportType");
        incomeReport.setReportGeneratedDate("1111111111");
        incomeReport.setRequestor(getRequestor());
        incomeReport.setConsumerPii(getConsumerPii());
        return incomeReport;


    }

    private static RespConsumerPii getConsumerPii() {
        RespConsumerPii respConsumerPii = new RespConsumerPii();
        respConsumerPii.setApplicantInformation(getApplicantInformation());
        respConsumerPii.setEmploymentHistory(getEmploymentHistory());

        return respConsumerPii;

    }

    private  static ApplicantInformation getApplicantInformation() {
        ApplicantInformation applicantInformation = new ApplicantInformation();
        applicantInformation.setDob(getDob());
        applicantInformation.setName(getName());
        applicantInformation.setPhone(getPhone());
        applicantInformation.setSsn(getSsn());
        applicantInformation.setCurrentAddress(getCurrentAddress());


        return applicantInformation;
    }

    private  static Ssn getSsn() {
        Ssn ssn = new Ssn();
        ssn.setSsn("xxx-xx-xxxx");
        return ssn;
    }

    private  static List<RespPhone> getPhone() {
        List<RespPhone> respPhones = new ArrayList<>();
        RespPhone respPhone = new RespPhone();
        respPhone.setNumber("12345567672");
        respPhone.setType("Home");
        respPhones.add(respPhone);
        return respPhones;
    }

    private static Name getName() {

        Name name  = new Name();
        name.setFirstName("TEST");
        name.setLastName("TEST");
        name.setMiddleName("A");
        name.setGenerationCode(null);

        return name;
    }

    private static Dob getDob() {
        Dob dob = new Dob();
        dob.setDob("01011984");
        return dob;
    }


    private static RespCurrentAddress getCurrentAddress() {
        RespCurrentAddress currentAddress = new RespCurrentAddress();
        currentAddress.setLine1("1234 TEST St");
        currentAddress.setLine2(null);
        currentAddress.setLine3(null);
        currentAddress.setCity("City");
        currentAddress.setState("State");
        currentAddress.setZipCode("111111");
        return currentAddress;

    }

    private static List<EmploymentHistory> getEmploymentHistory() {
        List<EmploymentHistory> employmentHistory = new ArrayList<>();
        EmploymentHistory employmentHistory1 = new EmploymentHistory();
        employmentHistory1.setOriginReportId("7c538bb6-770c-11eb-9439-0242ac130002");
        employmentHistory1.setOriginSourceId("OriginSource");
        employmentHistory1.setEmployerIdentificationNumber("111111111");
        employmentHistory1.setEmployerName("Test1 Employer");
        employmentHistory1.setOriginalHireDate("01012020");
        employmentHistory1.setMostRecentHireDate("01012020");
        employmentHistory1.setEmploymentStatus(getEmploymentStatus());
        employmentHistory1.setWorkStatus(getWorkStatus());
        employmentHistory1.setEmployerAddress(getEmployeeAddress());
        employmentHistory1.setPaymentHistory(getPaymentHistory());
        employmentHistory1.setTotalAnnualRenumeration(getTotalRenumeration());
        employmentHistory.add(employmentHistory1);

        EmploymentHistory employmentHistory2 = new EmploymentHistory();
        employmentHistory2.setOriginReportId("cc4ccad6-770e-11eb-9439-0242ac130002");
        employmentHistory2.setOriginSourceId("OriginSource");
        employmentHistory2.setEmployerIdentificationNumber("222222222");
        employmentHistory2.setEmployerName("Test2 Employer");
        employmentHistory2.setOriginalHireDate("01012021");
        employmentHistory2.setMostRecentHireDate("01012021");
        employmentHistory2.setEmploymentStatus(getEmploymentStatus());
        employmentHistory2.setWorkStatus(getWorkStatus());
        employmentHistory2.setEmployerAddress(getEmployeeAddress());
        employmentHistory2.setPaymentHistory(getPaymentHistory());
        employmentHistory2.setTotalAnnualRenumeration(getTotalRenumeration());
        employmentHistory.add(employmentHistory2);

        EmploymentHistory employmentHistory3 = new EmploymentHistory();
        employmentHistory3.setOriginReportId("d745f9da-770e-11eb-9439-0242ac130002");
        employmentHistory3.setOriginSourceId("OriginSource");
        employmentHistory3.setEmployerIdentificationNumber("333333333");
        employmentHistory3.setEmployerName("Test3 Employer");
        employmentHistory3.setOriginalHireDate("01012019");
        employmentHistory3.setMostRecentHireDate("01012020");
        employmentHistory3.setEmploymentStatus(getEmploymentStatus());
        employmentHistory3.setWorkStatus(getWorkStatus());
        employmentHistory3.setEmployerAddress(getEmployeeAddress());
        employmentHistory3.setPaymentHistory(getPaymentHistory());
        employmentHistory3.setTotalAnnualRenumeration(getTotalRenumeration());
        employmentHistory.add(employmentHistory3);

        return employmentHistory;
    }

    private static List<TotalAnnualRenumeration> getTotalRenumeration() {
        List<TotalAnnualRenumeration> totalAnnualRenumerations = new ArrayList<>();
        TotalAnnualRenumeration totalAnnualRenumeration1 = new TotalAnnualRenumeration();
        totalAnnualRenumeration1.setYear(0);
        totalAnnualRenumeration1.setAmount(12345.44);
        totalAnnualRenumeration1.setCurrencyCode("USD");
        totalAnnualRenumerations.add(totalAnnualRenumeration1);

        TotalAnnualRenumeration totalAnnualRenumeration2 = new TotalAnnualRenumeration();
        totalAnnualRenumeration2.setYear(0);
        totalAnnualRenumeration2.setAmount(12345.44);
        totalAnnualRenumeration2.setCurrencyCode("USD");
        totalAnnualRenumerations.add(totalAnnualRenumeration2);

        return totalAnnualRenumerations;
    }

    private static List<PaymentHistory> getPaymentHistory() {
        List<PaymentHistory> paymentHistory = new ArrayList<>();
        PaymentHistory paymentHistory1 = new PaymentHistory();
        paymentHistory1.setPayDate(null);
        paymentHistory1.setPayCycle("BIWEEKLY");
        paymentHistory1.setPayPeriod(getPayPeriod());
        paymentHistory1.setGrossPayAmount(getGrossPayAmount());

        paymentHistory.add(paymentHistory1);

        PaymentHistory paymentHistory2 = new PaymentHistory();
        paymentHistory2.setPayDate(null);
        paymentHistory2.setPayCycle("MONTHLY");
        paymentHistory2.setPayPeriod(getPayPeriod());
        paymentHistory2.setGrossPayAmount(getGrossPayAmount());
        paymentHistory.add(paymentHistory2);

        return paymentHistory;
    }

    private static GrossPayAmount getGrossPayAmount() {
        GrossPayAmount grossPayAmount = new GrossPayAmount();
        grossPayAmount.setAmount(1234.43);
        grossPayAmount.setCurrencyCode("USD");
        grossPayAmount.setHour(12.2);
        grossPayAmount.setYtdGrossPay(11.1);
        grossPayAmount.setCommission(1.1);
        grossPayAmount.setRate(50.0);
        grossPayAmount.setDeduction("Current Deduction");
        grossPayAmount.setCurrent(500.0);
        grossPayAmount.setYtdTotal(6000.0);



        return grossPayAmount;
    }

    private static PayPeriod getPayPeriod() {
        PayPeriod payPeriod = new PayPeriod();
        payPeriod.setStartDate(null);
        payPeriod.setEndDate("01012021");

        return payPeriod;
    }

    private static EmployerAddress getEmployeeAddress() {
        EmployerAddress employerAddress = new EmployerAddress();
        employerAddress.setLineOne("123 Test Address");
        employerAddress.setLineTwo(null);
        employerAddress.setLineThree(null);
        employerAddress.setCityName("City");
        employerAddress.setState("State");
        employerAddress.setCountryCode(null);
        employerAddress.setPostalCode("12324-2054");

        return employerAddress;
    }

    private static WorkStatus getWorkStatus() {
        WorkStatus workStatus = new WorkStatus();
        workStatus.setCode(null);
        workStatus.setName("ACTIVE");
        return workStatus;
    }

    private static EmploymentStatus getEmploymentStatus() {
        EmploymentStatus employmentStatus = new EmploymentStatus();
        employmentStatus.setCode(null);
        employmentStatus.setName("ACTIVE");
        return employmentStatus;
    }

    private static IncomeRequestor getRequestor() {
        IncomeRequestor incomeRequestor = new IncomeRequestor();
        incomeRequestor.setVerifierName("1111111");
        incomeRequestor.setVerifierName("Example Lender");
        return incomeRequestor;
    }
}
