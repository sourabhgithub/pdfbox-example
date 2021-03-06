package com.pdfbox.pdfboxexample;

import com.pdfbox.request.IncomeAndEmploymentRequest;
import com.pdfbox.testdata.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rst.pdfbox.layout.elements.Document;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@RestController
public class Controller {

    @Autowired
    PDFServices service;


    @GetMapping("/incomeEmployment")
    public ResponseEntity<Resource> returnObjectInBrowser( HttpServletResponse response) throws IOException, ParseException {


        response.setContentType("application/force-download");

       // response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Disposition","attachment; filename=" + "IncomeAndEmploymentDetails.pdf");//fileName);
        IncomeAndEmploymentRequest incomeAndEmploymentRequest = TestData.getIncomeAndEmploymentRequest();
        Document document = service.generatePDF(incomeAndEmploymentRequest);
        document.save(response.getOutputStream());

        response.flushBuffer();



        return null;
    }
}