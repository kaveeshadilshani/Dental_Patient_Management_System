package com.doerit.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.doerit.model.Patient;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfPatientSticker {

	public ByteArrayOutputStream createPdf(Patient patient) throws DocumentException, IOException {
		
		FontFactory.defaultEmbedding = true;
		FontFactory.registerDirectories();

		float left = 0;
		float right = 0;
		float top = 10;
		float bottom = 5;
		float stickerWidth = 300;
		float stickerHeight = 70;
		
		Rectangle stickerSize = new Rectangle(stickerWidth, stickerHeight);
		Document document = new Document();
		document.setPageSize(stickerSize);
		document.setMargins(left, right, top, bottom);
		ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();

		PdfWriter writer = PdfWriter.getInstance(document, baosPDF);
		document.open();

		document.add(createDateAndBarCode(patient));
		/*
		 * 
		BufferedImage bufferedImage = BarCodeImageUtility.createBarCode(patient.getSerialNumber(), 30f);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		ImageIO.write(bufferedImage, "png", baos);
		Image barCode = Image.getInstance(baos.toByteArray());
		barCode.setAlignment(Element.ALIGN_CENTER);
		document.add(barCode);

        Paragraph patientSerialParagraph = new Paragraph(patient.getSerialNumber(), PdfFont.SuperScriptNormal);
        patientSerialParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(patientSerialParagraph);	        

        Paragraph patientNameParagraph = new Paragraph(patient.getPrintNameForSticker(), PdfFont.SuperScriptNormal);
        patientNameParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(patientNameParagraph);	        
		*/
		document.close();

		return baosPDF;
	}
	
	private PdfPTable createDateAndBarCode(Patient patient) throws DocumentException, IOException {

		PdfPTable table = new PdfPTable(2);
		table.setSpacingBefore(0);
		table.setWidthPercentage(100);
		table.setWidths(new float[] { 1, 1 });
		table.getDefaultCell().setBorder(0);

		BufferedImage bufferedImage = BarCodeImageUtility.createBarCode(patient.getSerialNumber(), 30f);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		ImageIO.write(bufferedImage, "png", baos);
		Image iTextImage = Image.getInstance(baos.toByteArray());

		PdfPCell imageCell = new PdfPCell(iTextImage);
		imageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		imageCell.setBorder(0);
		imageCell.setPadding(0);

		table.addCell(imageCell);
		table.addCell(imageCell);
		
		Paragraph serialLabel = new Paragraph(patient.getSerialNumber(), PdfFont.Level1Value);
		serialLabel.setAlignment(Element.ALIGN_CENTER);
		PdfPCell serialCell = new PdfPCell(serialLabel); // new Phrase(12, dateLabel, PdfFont.Level1Header));
		serialCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		serialCell.setBorder(0);
		serialCell.setPadding(0);
		table.addCell(serialCell);
		table.addCell(serialCell);
		
		Paragraph nameLabel = new Paragraph(patient.getPrintName(), PdfFont.SuperScriptNormal);
		nameLabel.setAlignment(Element.ALIGN_CENTER);
		PdfPCell nameCell = new PdfPCell(nameLabel); // new Phrase(12, dateLabel, PdfFont.Level1Header));
		nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		nameCell.setBorder(0);
		nameCell.setPadding(0);
		
		table.addCell(nameCell);
		table.addCell(nameCell);
		
		return table;

	}

	
}
