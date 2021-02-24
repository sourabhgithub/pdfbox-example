package com.pdfbox.pdfboxexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@RestController
public class Controller {

    @Autowired
    PDFServices service;
    @GetMapping("/incomeEmployment")
    public ResponseEntity<Resource> returnObjectInBrowser( HttpServletResponse response) throws IOException, ParseException {
        service.generatePDF(response);

        return null;
    }
}