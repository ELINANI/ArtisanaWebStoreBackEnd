package com.artisanastore.ecommerce.Pdf;

import com.artisanastore.ecommerce.Domaine.ClientVO;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class GeneratePdf {

    public void generatePDF(HttpServletResponse response , String nameOperation , ClientVO clientVO) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());
        document.resetPageCount();
        document.open();
        document.add(new Paragraph(nameOperation));
        document.close();
    }
    public Document commandeDoc(){
        Document document = new Document(PageSize.A4);
        return  document ;
    }
}
