package com.doerit.util;

import org.apache.struts2.dispatcher.ng.servlet.ServletHostConfig;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class PdfPatientSettings {

	public static final String NO_LINE_BREAK_UNICODE = "\u00a0";
	
	public static Paragraph HEADER() {

		String part1 = "Dental Hospital (Teaching) - Peradeniya";
		String part2 = "Patient Central Record";

		Paragraph header = new Paragraph(part1, PdfFont.FontHeader);

		header.add(new Chunk(part2, PdfFont.FontHeader));

		header.setAlignment(Element.ALIGN_CENTER);
		return header;
	}
	
	public static String FOOTER() {

		String footer = "Copyright © All Rights Reserved - University of Peradeniya - Faculty of Dental Sciences.";

		return footer;
	}
	
}
