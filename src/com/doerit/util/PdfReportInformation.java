package com.doerit.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.doerit.model.DistrictRegistrationMapper;
import com.doerit.model.Patient;
import com.doerit.model.TotalRegistrations;
import com.doerit.service.PatientService;
import com.doerit.util.Pager;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class PdfReportInformation {
	
	private TotalRegistrations registrations;
	private List<Patient> patients;
	private List<DistrictRegistrationMapper> districts;
	private String reportType;
	
	public ByteArrayOutputStream createPdf(List<Patient> patientList, List<DistrictRegistrationMapper> districtList, TotalRegistrations RegTot, String Type) throws DocumentException, IOException {
		
		this.patients = patientList;
		this.districts = districtList;
		this.registrations = RegTot;
		this.reportType = Type;
		
		//System.out.println(districts);
		
		FontFactory.defaultEmbedding = true;
		FontFactory.registerDirectories();

		float left = PdfSettings.REPORT_LEFT; // 30 mm with 72 px/inch
		float right = PdfSettings.REPORT_RIGHT; // 30 mm
		float top = PdfSettings.TOP; // 20 mm
		float bottom = PdfSettings.BOTTOM; // 20 mm
		
		Document document = new Document(PageSize.A4, left, right, top, bottom);
		ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();

		
		PdfWriter writer = PdfWriter.getInstance(document, baosPDF);
		//writer.setPageEvent(new PdfPatientHeaderFooter());
		document.open();

		Chunk headerChunk1 = new Chunk("Dental Hospital (Teaching) - Peradeniya");
		headerChunk1.setUnderline(1.2f, -6.0f);
        Paragraph headerLine1 = new Paragraph(headerChunk1);
        headerChunk1.setFont(PdfFont.FontHeader);
        headerLine1.setAlignment(Element.ALIGN_CENTER);
        document.add(headerLine1);
        
        Chunk headerChunk2 = new Chunk("Registration Report (" + this.reportType +")");
		headerChunk2.setUnderline(1.2f, -6.0f);
        Paragraph headerLine2 = new Paragraph(headerChunk2);
        headerChunk2.setFont(PdfFont.FontHeader);
        headerLine2.setAlignment(Element.ALIGN_CENTER);
        document.add(headerLine2);
        
		prepareTables(document);
		
		document.close();

		return baosPDF;
	}
	
	private void prepareTables(Document document) throws DocumentException, IOException {
				
		Paragraph gap = new Paragraph();
		gap.setSpacingBefore(10);
		document.add(gap);
		
		LineSeparator ls = new LineSeparator();
		ls.setLineColor(new BaseColor(200, 200, 200));

		document.add(new Chunk(ls));
		gap.setSpacingBefore(10);
		document.add(gap);

		document.add(createTotalCounts());
		document.add(gap);
		document.add(new Chunk(ls));
		
		document.add(createDistrictCounts());
		document.add(gap);
		document.add(new Chunk(ls));
		
		document.add(createRegisteredTable());
		document.add(gap);
		document.add(new Chunk(ls));
			
		
	}
	
	private PdfPTable createRegisteredTable() throws DocumentException, IOException {

		PdfPTable table = new PdfPTable(4);
		table.setWidths(new float[] { 2, 3, 2, 1 });
		table.getDefaultCell().setBorder(1);
		
		//Table Column Titles
		table.addCell(createCellValue("Serial No.", PdfFont.Level2Header));
		table.addCell(createCellValue("Name", PdfFont.Level2Header));
		table.addCell(createCellValue("Date of Birth", PdfFont.Level2Header));
		table.addCell(createCellValue("Gender", PdfFont.Level2Header));
		
		PdfPCell cell = createCellValue("  ", PdfFont.Level2Value);
		cell.setColspan(4);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		if(!patients.isEmpty()) {
			for(int i = 0; i<patients.size(); i++) {
				table.addCell(createCellValue(patients.get(i).getSerialNumber(), PdfFont.Level2Value));
				table.addCell(createCellValue(patients.get(i).getPrintName(), PdfFont.Level2Value));
				table.addCell(createCellValue(patients.get(i).getBirthDayString(), PdfFont.Level2Value));
				table.addCell(createCellValue(patients.get(i).getSex(), PdfFont.Level2Value));
				
			}
		}
		
		
		return table;

	}
	
	private PdfPTable createDistrictCounts() throws DocumentException, IOException{
		
		PdfPTable table = new PdfPTable(8);
		table.setWidths(new float[] { 3, 1, 3, 1, 3, 1, 3, 1});
		table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				
		
			for(int i = 0; i<districts.size(); i++) {
				
					table.addCell(createCellValue(districts.get(i).getDistrict()+": ", PdfFont.Level2Header));
				if(districts.get(i).getDistrictTotal() != null) {	
					table.addCell(createCellValue(districts.get(i).getDistrictTotal().toString(), PdfFont.Level2Value));				
				}else {
					table.addCell(createCellValue("0", PdfFont.Level2Value));
				}
			}
			
			table.addCell(createCellValue(" ", PdfFont.Level2Value));
			table.addCell(createCellValue(" ", PdfFont.Level2Value));
			table.addCell(createCellValue(" ", PdfFont.Level2Value));
			table.addCell(createCellValue(" ", PdfFont.Level2Value));
			table.addCell(createCellValue(" ", PdfFont.Level2Value));
			table.addCell(createCellValue(" ", PdfFont.Level2Value));
		return table;
		
	}
	
	private PdfPTable createTotalCounts() throws DocumentException, IOException {

		PdfPTable table = new PdfPTable(4);
		table.setWidths(new float[] { 3, 2, 2, 2 });
		table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		
		if(this.registrations.getMaleTotal() != null) {
			table.addCell(createCellValue("Total Patients:", PdfFont.Level2Header));
			table.addCell(createCellValue(this.registrations.getTotal().toString(), PdfFont.Level2Value));
			table.addCell("");
			table.addCell("");
			
			table.addCell(createCellValue("Total Males:", PdfFont.Level2Header));
			table.addCell(createCellValue(this.registrations.getMaleTotal().toString(), PdfFont.Level2Value));
			table.addCell("");
			table.addCell("");
			
			table.addCell(createCellValue("Total Females:", PdfFont.Level2Header));
			table.addCell(createCellValue(this.registrations.getFemaleTotal().toString(), PdfFont.Level2Value));
			table.addCell("");
			table.addCell("");
			
			table.addCell(createCellValue("Total Children:", PdfFont.Level2Header));
			table.addCell(createCellValue(this.registrations.getChildTotal().toString(), PdfFont.Level2Value));
			table.addCell("");
			table.addCell("");
		}else {
			PdfPCell cell = createCellValue("No Patient Records", PdfFont.Level2Value);
			cell.setColspan(4);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}
			
		

		return table;

	}
	
	private PdfPCell createCellValue(String label, Font font) {
		PdfPCell pdfPCell = new PdfPCell(new Phrase(16, label, font));
		pdfPCell.setBorder(0);

		return pdfPCell;
	}
	
	
	

}
