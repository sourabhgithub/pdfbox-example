package com.pdfbox.pdfboxexample;

import com.pdfbox.request.IncomeAndEmploymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rst.pdfbox.layout.elements.Document;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@Service
public class PDFServices {
    @Autowired
    PDFGenerationService pdfGenerator;


    public Document generatePDF(IncomeAndEmploymentRequest incomeAndEmploymentRequest) throws IOException, ParseException {
       return pdfGenerator.generatePDF(incomeAndEmploymentRequest);
    }

}
