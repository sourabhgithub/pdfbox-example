package com.pdfbox.pdfboxexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdfbox.response.ApplicantInformation;
import com.pdfbox.response.EmployeeAddress;
import com.pdfbox.response.EmploymentHistory;
import com.pdfbox.response.IncomeAndEmploymentResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;

@Service
public class PDFServices {
//    @Autowired
//    PDFGenerationService pdfGenerator;

    public  IncomeAndEmploymentResponse getIncomeAndEmploymentResponse(){
        IncomeAndEmploymentResponse response = null;
        try
        {
            String jsonString="{\n" +
                    "  \"incomeReport\": {\n" +
                    "    \"reportId\": \"e46444b0-d061-4f13-8b5a-317a0c831a62\",\n" +
                    "    \"reportType\": \"ExpVerify-Plus\",\n" +
                    "    \"reportGeneratedDate\": \"1613776591\",\n" +
                    "    \"requestor\": {\n" +
                    "      \"subscriberCode\": \"2733780\",\n" +
                    "      \"verifierName\": \"Example Lender\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"consumerPii\": {\n" +
                    "    \"applicantInformation\": {\n" +
                    "      \"name\": {\n" +
                    "        \"lastName\": \"MILLER\",\n" +
                    "        \"firstName\": \"DOROTHY\",\n" +
                    "        \"middleName\": \"B\",\n" +
                    "        \"generationCode\": null\n" +
                    "      },\n" +
                    "      \"ssn\": {\n" +
                    "        \"ssn\": \"123456\"\n" +
                    "      },\n" +
                    "      \"dob\": {\n" +
                    "        \"dob\": null\n" +
                    "      },\n" +
                    "      \"phone\": null,\n" +
                    "      \"currentAddress\": {\n" +
                    "        \"line1\": \"2801 TORREYA CT\",\n" +
                    "        \"line2\": null,\n" +
                    "        \"line3\": null,\n" +
                    "        \"city\": \"FLOWER MOUND\",\n" +
                    "        \"state\": \"TX\",\n" +
                    "        \"zipCode\": \"750283699\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"employmentHistory\": [\n" +
                    "      {\n" +
                    "        \"originReportld\": \"664cd347-3a47-927b-133e-01b2b02e5eb0\",\n" +
                    "        \"originSourceld\": null,\n" +
                    "        \"employerldentificationNumber\": \"857630135\",\n" +
                    "        \"employerName\": \"Lueilwitz, Mayer and Rogahn\",\n" +
                    "        \"originalHireDate\": \"01162020\",\n" +
                    "        \"mostRecentHireDate\": \"11162020\",\n" +
                    "        \"employmentStatus\": {\n" +
                    "          \"code\": null,\n" +
                    "          \"name\": \"FULL-TIME\"\n" +
                    "        },\n" +
                    "        \"workStatus\": {\n" +
                    "          \"code\": null,\n" +
                    "          \"name\": \"ACTIVE\"\n" +
                    "        },\n" +
                    "        \"employerAddress\": {\n" +
                    "          \"lineOne\": \"065 Hoyt Centers\",\n" +
                    "          \"lineTwo\": null,\n" +
                    "          \"lineThree\": null,\n" +
                    "          \"cityName\": \"Rexport\",\n" +
                    "          \"state\": \"Cambridgeshire\",\n" +
                    "          \"countryCode\": null,\n" +
                    "          \"postalCode\": \"34712-2054\"\n" +
                    "        },\n" +
                    "        \"paymentHistory\": [\n" +
                    "          {\n" +
                    "            \"payDate\": null,\n" +
                    "            \"payCycle\": \"BIWEEKLY\",\n" +
                    "            \"payPeriod\": {\n" +
                    "              \"startDate\": null,\n" +
                    "              \"endDate\": \"02192021\"\n" +
                    "            },\n" +
                    "            \"grossPayAmount\": {\n" +
                    "              \"amount\": 56788.97,\n" +
                    "              \"currencyCode\": \"USD\"\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"totalAnnual Remuneration\": [\n" +
                    "          {\n" +
                    "            \"year\": 0,\n" +
                    "            \"amount\": 164048.47,\n" +
                    "            \"cu rrencyCode\": \"USD\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "}";

            JSONObject json = new JSONObject(jsonString);
            response = new ObjectMapper().readValue(json.getJSONObject("incomeReport").toString(), IncomeAndEmploymentResponse.class);

            JSONObject consumerPii =json.getJSONObject("consumerPii");
            response.setApplicantInformation( new ObjectMapper().readValue(consumerPii.getJSONObject("applicantInformation").getJSONObject("name").toString(), ApplicantInformation.class));
            response.getApplicantInformation().setEmployeeAddress(new ObjectMapper().readValue(consumerPii.getJSONObject("applicantInformation").getJSONObject("currentAddress").toString(), EmployeeAddress.class));
            response.setSsn(consumerPii.getJSONObject("applicantInformation").getJSONObject("ssn").getString("ssn"));
            //response.setDob(consumerPii.getJSONObject("applicantInformation").getJSONObject("dob").getString("dob"));
            JSONArray employmentHistoryArray = consumerPii.getJSONArray("employmentHistory");
            for (Object empHistory : employmentHistoryArray) {
                EmploymentHistory history = new ObjectMapper().readValue(empHistory.toString(), EmploymentHistory.class);
               response.getEmploymentHistory().add(history);
            }

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;

    }

    public void generatePDF(IncomeAndEmploymentResponse response) throws IOException, ParseException {
       new PDFGenerationService().generatePDF(response);
    }
    public static void main(String[] args) throws IOException, ParseException {
        PDFServices serv = new PDFServices();
        IncomeAndEmploymentResponse response = serv.getIncomeAndEmploymentResponse();
        serv.generatePDF(response);
        
    };
}
