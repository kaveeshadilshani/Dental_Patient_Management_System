package com.doerit.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.struts2.StrutsStatics;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;
import com.opensymphony.xwork2.ActionContext;

public class PdfFont {
	
	
	private static BaseFont getTnrBaseNormalFont() {
		
		File f = new File(((ServletContext) ActionContext.getContext().get(StrutsStatics.SERVLET_CONTEXT)).getRealPath("/fonts/"));
                
		try {
			BaseFont unicode = BaseFont.createFont(f.getAbsolutePath().concat("/TIMES.TTF"), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			return unicode;
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BaseFont getTnrBaseNormalBoldFont() {
		File f = new File(((ServletContext) ActionContext.getContext().get(StrutsStatics.SERVLET_CONTEXT)).getRealPath("/fonts/"));
        
		try {
			BaseFont unicode = BaseFont.createFont(f.getAbsolutePath().concat("/TIMESBD.TTF") , BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			return unicode;
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BaseFont getTnrBaseItelicFont() {
		File f = new File(((ServletContext) ActionContext.getContext().get(StrutsStatics.SERVLET_CONTEXT)).getRealPath("/fonts/"));
        
		try {
			BaseFont unicode = BaseFont.createFont(f.getAbsolutePath().concat("/TIMESI.TTF") , BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			return unicode;
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static BaseFont getTnrBaseBoldItelicFont() {
		File f = new File(((ServletContext) ActionContext.getContext().get(StrutsStatics.SERVLET_CONTEXT)).getRealPath("/fonts/"));
        
		try {
			BaseFont unicode = BaseFont.createFont(f.getAbsolutePath().concat("/TIMESBI.TTF") , BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			return unicode;
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Font getContentNormal() {
		Font font = new Font(getTnrBaseNormalFont(), 11);
		return font;
	}
	
	public static Font getContentItelic() {
		Font font = new Font(getTnrBaseItelicFont(), 11);
		return font;
	}
	
	public static Font getTableOfContentAuthors() {
		Font font = new Font(getTnrBaseItelicFont(), 10);
		return font;
	}
	
	public static Font getTableOfContentTitle() {
		Font font = new Font(getTnrBaseNormalFont(), 10);
		return font;
	}
	
	public static Font getTableOfContentPageNumber() {
		Font font = new Font(getTnrBaseNormalBoldFont(), 10);
		return font;
	}
	
	public static Font getKeywordNormal() {
		Font font = new Font(getTnrBaseNormalFont(), 11);
		return font;
	}
	
	public static Font getKeywordItelic() {
		Font font = new Font(getTnrBaseItelicFont(), 11);
		return font;
	}
	
	public static Font getTitleNormal() {
		Font font = new Font(getTnrBaseNormalBoldFont(), 12);
		return font;
	}
	
	public static Font getTitleItelic() {
		Font font = new Font(getTnrBaseBoldItelicFont(), 12);
		return font;
	}
	
	public static final Font SuperScriptItalic = FontFactory.getFont("Times New Roman", 8, Font.NORMAL);
	public static final Font SuperScriptNormal = FontFactory.getFont("Times New Roman", 9, Font.NORMAL);
	public static final Font FontHeader = FontFactory.getFont("Times New Roman", 14, Font.BOLD);
	//public static final Font FontTitleNormal = FontFactory.getFont("Times New Roman", 12, Font.BOLD);
	//public static final Font FontTitleItelic = FontFactory.getFont("Times New Roman", 12, Font.BOLD|Font.ITALIC);
	public static final Font Level1Header = FontFactory.getFont("Times New Roman", 12, Font.BOLD);
	public static final Font Level2Header = FontFactory.getFont("Times New Roman", 11, Font.BOLD);
	public static final Font Level2Value= FontFactory.getFont("Times New Roman", 11, Font.NORMAL);
	public static final Font Level1Value= FontFactory.getFont("Times New Roman", 12, Font.NORMAL);
	public static final Font FontAuthorsAffiliation = FontFactory.getFont("Times New Roman", 11, Font.NORMAL);
	public static final Font TenNormal = FontFactory.getFont("Times New Roman", 10, Font.NORMAL);
	//public static final Font FontContentNormal = FontFactory.getFont("Times New Roman", 11, Font.NORMAL);
	//public static final Font FontContentItelic = FontFactory.getFont("Times New Roman", 11, Font.NORMAL|Font.ITALIC);
	public static final Font FontAck = FontFactory.getFont("Times New Roman", 11, Font.NORMAL|Font.ITALIC);
	public static final Font FontKeywordLabel = FontFactory.getFont("Times New Roman", 11, Font.BOLD);
	//public static final Font FontKeywordNormal = FontFactory.getFont("Times New Roman", 11, Font.NORMAL);
	//public static final Font FontKeywordItelic = FontFactory.getFont("Times New Roman", 11, Font.NORMAL|Font.ITALIC);
	
	public static Font getHeaderFont () {
		try {
			Font f = FontFactory.getFont("Vijaya", 10, Font.ITALIC);
			return f;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Font f = FontFactory.getFont("Monotype Corsiva", 10, Font.ITALIC);
		return f;
	}
}
