package com.pdfbox.pdfboxexample;

import com.pdfbox.response.EmploymentHistory;
import com.pdfbox.response.IncomeAndEmploymentResponse;
import com.pdfbox.response.PaymentHistory;
import org.springframework.stereotype.Service;
import rst.pdfbox.layout.elements.Document;
import rst.pdfbox.layout.elements.Frame;
import rst.pdfbox.layout.elements.Paragraph;
import rst.pdfbox.layout.shape.Rect;
import rst.pdfbox.layout.shape.RoundRect;
import rst.pdfbox.layout.shape.Stroke;
import rst.pdfbox.layout.text.Alignment;
import rst.pdfbox.layout.text.BaseFont;
import rst.pdfbox.layout.text.Indent;
import rst.pdfbox.layout.text.SpaceUnit;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PDFGenerationService {

    private static  String indentString ="    ";
    private final int HEADER_FONTSIZE = 11;
    private final int GENERALFONT_FONTSIZE = 9;

    private  void generateHeaderTextContent(Document document) throws IOException {
        Paragraph paragraph1 = new Paragraph();
        paragraph1.addMarkup("*VERIFICATION OF EMPLOYMENT AND INCOME \n\n *", 12, BaseFont.Times);
        paragraph1.setAlignment(Alignment.Right);
        document.add(paragraph1);
    }

    private  void generatePersonalInfo(Document document, String name, String address, String ssn, String dob) throws IOException {
        Paragraph paragraph = new Paragraph();
        StringBuilder content = new StringBuilder("*"+name+"*");
        content.append(indentString).append(address).append("\n\n").append("Social Security Number: ").append("*"+ssn+"*")
                .append(indentString).append("Date of birth : ").append(dob).append("\n\n");
        paragraph.addMarkup(content.toString(),HEADER_FONTSIZE,BaseFont.Times);
        document.add(paragraph);
    }

    private  void generateRequestInfo(Document document,String requestFor,String requestId,String reportId,String dateRequested,String loanNumber) throws IOException {
        Paragraph paragraph = new Paragraph();
        paragraph.addMarkup("",12,BaseFont.Times);
        Frame frame = new Frame(paragraph,document.getPageWidth(),null);
        frame.setShape(new Rect());
        frame.setBorder(Color.GRAY, new Stroke(1));
        document.add(frame);
        Paragraph paragraph1 = new Paragraph();
        StringBuilder contentBuilder = new StringBuilder();
        contentBuilder.append("RequestFor :").append(requestFor).append(indentString)
                .append("Request ID:").append(requestId).append(indentString)
                .append("Report Id:").append(reportId).append(indentString)
                .append("Date Requested:").append(dateRequested).append(indentString)
                .append("Loan number:").append(loanNumber).append("\n\n");
        paragraph1.addMarkup(contentBuilder.toString(),GENERALFONT_FONTSIZE,BaseFont.Times);
        document.add(paragraph1);
    }

    private  void generateEmploymentInfo(Document document, List<EmploymentHistory> employmentDetails) throws IOException, ParseException {

        Paragraph paragraph = new Paragraph();
        paragraph.addMarkup("*Employment and Income Details* \n\n",11,BaseFont.Times);

        StringBuilder content = new StringBuilder();

        int i =0;
        for(EmploymentHistory history : employmentDetails){
            i++;
            content = new StringBuilder();
            content.append("Employer "+i+" of "+employmentDetails.size()).append("\n")
                    .append("*"+getSafeString(history.getEmployerName())+"*").append(indentString).append(getSafeString(history.getEmployerAddress().toString())).append("\n\n");

            content.append("{color:#0000ff}Title").append(getIntend("",20)).
                    append("{color:#0000ff}Hire Date").append(getIntend("",10)).
                    append("{color:#0000ff}Employment Status").append(getIntend("",10)).
                    append("{color:#0000ff}Work Status").append(getIntend("",10)).
                    append("{color:#0000ff}Tenure\n\n");
            paragraph.addMarkup(content.toString(), HEADER_FONTSIZE, BaseFont.Times);
            content = new StringBuilder();
            String title = history.getEmploymentStatus().getCode();
            title = title == null || title.isEmpty() ? "Not Available" : title;
            SimpleDateFormat formatter = new SimpleDateFormat("mmDDyyyy");

            Date hireDate = formatter.parse(history.getOriginalHireDate());
            SimpleDateFormat sFrmt = new SimpleDateFormat("mm/DD/yyyy");
            String hireDateStr = sFrmt.format(hireDate);

            String status = history.getEmploymentType().getName();
            status = status == null || status.isEmpty() ? "":status;

            String eStatus = history.getEmploymentStatus().getName();
            eStatus = eStatus == null || eStatus.isEmpty() ? "":eStatus;

            LocalDate dateBefore= hireDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dateAfter = LocalDate.now();
            long months = ChronoUnit.MONTHS.between(dateBefore,dateAfter);

            content.append(title).append(getIntend(title,20)).
                    append(hireDateStr).append(getIntend(hireDateStr,20)).
                    append(status).append(getIntend(status,25)).
                    append(eStatus).append(getIntend(eStatus,20)).
                    append(months+" months\n\n");

            Optional<PaymentHistory> paymentHistoryOptional = history.getPaymentHistory().stream().findFirst();
            PaymentHistory pHistory = paymentHistoryOptional.orElse(new PaymentHistory());
            paragraph.addMarkup(content.toString(), HEADER_FONTSIZE, BaseFont.Times);
            paragraph.addMarkup("{color:#0000ff}Pay Date :", HEADER_FONTSIZE, BaseFont.Times);
            paragraph.addMarkup(pHistory.getPayDate()+indentString, HEADER_FONTSIZE, BaseFont.Times);

            paragraph.addMarkup("{color:#0000ff}Pay Frequency :", HEADER_FONTSIZE, BaseFont.Times);
            paragraph.addMarkup(getSafeString(pHistory.getPayCycle())+indentString, HEADER_FONTSIZE, BaseFont.Times);

            paragraph.addMarkup("{color:#0000ff}Reporting period :", HEADER_FONTSIZE, BaseFont.Times);
            paragraph.addMarkup(pHistory.getPayperiod().toString()+"\n\n", HEADER_FONTSIZE, BaseFont.Times);


            content = new StringBuilder();
            content.append("{color:#0000ff}Earning").append(getIntend("",8)).
                    append("{color:#0000ff}Rate").append(getIntend("",5)).
                    append("{color:#0000ff}Hours").append(getIntend("",5)).
                    append("{color:#0000ff}Gross Pay").append(getIntend("",5)).
                    append("{color:#0000ff}Over Time").append(getIntend("",5)).
                    append("{color:#0000ff}Bonuses").append(getIntend("",5))
                    .append("{color:#0000ff}Commissions").append(getIntend("",5)).
                    append("{color:#0000ff}YTD Gross Pay\n\n");
            paragraph.addMarkup(content.toString(), HEADER_FONTSIZE, BaseFont.Times);
           for(PaymentHistory payment : history.getPaymentHistory()) {
               String hours = payment.getGrossPayAmount().getHour()== null ? "N/A" : String.valueOf(payment.getGrossPayAmount().getHour());
               String rate = payment.getGrossPayAmount().getRate()== null ? "N/A" : String.valueOf(payment.getGrossPayAmount().getRate());
               String overTime = payment.getGrossPayAmount().getOvertime()== null ? "N/A" : String.valueOf(payment.getGrossPayAmount().getOvertime());
               String bonus = payment.getGrossPayAmount().getBonuses()== null ? "N/A" : String.valueOf(payment.getGrossPayAmount().getBonuses());
               String commissin = payment.getGrossPayAmount().getCommission()== null ? "N/A" : String.valueOf(payment.getGrossPayAmount().getCommission());
               String ytdGrossPay = payment.getGrossPayAmount().getYtdGrossPay()== null ? "N/A" : String.valueOf(payment.getGrossPayAmount().getYtdGrossPay());
               String grossPay = payment.getGrossPayAmount().getAmount()== null ? "N/A" : String.valueOf(payment.getGrossPayAmount().getAmount());

               content = new StringBuilder();
               content.append("Base Pay").append(getIntend("Base Pay", 12)).
                       append(rate).append(getIntend(rate, 9)).
                       append(hours).append(getIntend(hours, 10)).
                       append(grossPay).append(getIntend(grossPay, 14)).
                       append(overTime).append(getIntend(overTime, 19)).
                       append(bonus).append(getIntend(bonus, 17))
                       .append(commissin).append(getIntend(commissin, 22)).
                       append(ytdGrossPay+"\n");
           }
            paragraph.addMarkup(content.toString()+"\n\n", HEADER_FONTSIZE, BaseFont.Times);

            paragraph.setAlignment(Alignment.Center);

            content = new StringBuilder();
            content.append("{color:#0000ff}Deduction").append(getIntend("",15)).
                    append("{color:#0000ff}Current").append(getIntend("",5)).
                    append("{color:#0000ff}YTD Total\n");
            paragraph.add(new Indent(70, SpaceUnit.pt));
            paragraph.addMarkup(content.toString(), HEADER_FONTSIZE, BaseFont.Times);
            paragraph.setAlignment(Alignment.Center);
            content = new StringBuilder();
            content.append("Fica Medicare").append(getIntend("Fica Medicare",20)).
                    append("$400").append(getIntend("$400",9)).
                    append("$70000\n");
            paragraph.addMarkup(content.toString()
                    +"\n\n", 11, BaseFont.Times);
            paragraph.setAlignment(Alignment.Left);
        }

        Frame frame = new Frame(paragraph, document.getPageWidth(),null);
        frame.setShape(new RoundRect(15));
        frame.setBorder(Color.GRAY, new Stroke(3));
        frame.setPadding(20, 15, 10, 15);
        frame.setMargin(0, 50, 20, 10);
        document.add(frame);
    }

    private  String getIntend(String content,int base){
        String returnString ="";
        for(int i = 0 ; i< base-content.length() ;i++){
            returnString +=" ";
        }
        return returnString;
    }

    public void generatePDF(HttpServletResponse httpResponse  , IncomeAndEmploymentResponse response) throws IOException, ParseException {
        Document document = new Document(40, 50, 40, 60);
        generateHeaderTextContent(document);
        generatePersonalInfo(document,getSafeString(response.getApplicantInformation().getName()),getSafeString(response.getApplicantInformation().getAddress()),getSafeString(response.getSsn()),getSafeString(response.getDob()));
        generateRequestInfo(document,getSafeString(response.getRequestor().getVerifierName()),getSafeString(response.getRequestor().getSubScriberId()),getSafeString(response.getReportId()),getSafeString(response.getReportGeneratedDate()),getSafeString(response.getRequestor().getSubScriberId()));
        generateEmploymentInfo(document, response.getEmploymentHistory());


//        final OutputStream outputStream = new FileOutputStream(
//                "IncomeAndEmploymentDetails.pdf");
        document.save(httpResponse.getOutputStream());

        httpResponse.addHeader("Content-disposition", "attachment; filename=" + "IncomeAndEmploymentDetails.pdf");
        httpResponse.setContentType("application/pdf");
        httpResponse.flushBuffer();
    }

    private String getSafeString(String obj){
        if(obj == null)
            return "";
        return  obj;
    }

}
