package com.pdfbox.pdfboxexample;

import com.pdfbox.request.IncomeAndEmploymentRequest;
import com.pdfbox.response.IncomeAndEmploymentResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/incomeEmployment")
    public IncomeAndEmploymentResponse returnObjectInBrowser() {
        IncomeAndEmploymentRequest someClass = new IncomeAndEmploymentRequest();

        return null;
    }
}