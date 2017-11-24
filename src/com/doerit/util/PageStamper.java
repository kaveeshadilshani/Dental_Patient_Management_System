package com.doerit.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.tool.xml.*;
import com.itextpdf.tool.xml.css.*;
 
import java.io.IOException;
 
/**
 * Adds page number to al the pages except the first.
 */
public class PageStamper extends PdfPageEventHelper { 
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        final int currentPageNumber = writer.getCurrentPageNumber();
 
        if (currentPageNumber == 1) {
           // return;
        }
 
        try {
            final Rectangle pageSize = document.getPageSize();
            final PdfContentByte directContent = writer.getDirectContent();
 
            directContent.setColorFill(BaseColor.BLACK);
            directContent.setFontAndSize(BaseFont.createFont(), 10);
 
            directContent.setTextMatrix(pageSize.getRight(60), pageSize.getBottom(20));
            directContent.showText("Page|"+String.valueOf(currentPageNumber));
 
        } catch (DocumentException | IOException e) {
            //logger.error("PDF generation error", e);
        }
    }
}

