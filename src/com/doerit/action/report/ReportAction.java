package com.doerit.action.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doerit.action.AbstractDownloadManamentAction;
import com.doerit.model.DistrictRegistrationMapper;
import com.doerit.model.Patient;
import com.doerit.model.TotalRegistrations;
import com.doerit.service.PatientService;
import com.doerit.util.PdfReportInformation;
import com.doerit.util.State;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.zugferd.checkers.basic.DateFormatCode;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class ReportAction extends AbstractDownloadManamentAction {

	private static final long serialVersionUID = 1L;
	private String customDate;
	private String customEndDate;
	private TotalRegistrations register;
	private Character viewType;
	private String pattern = "%Y-%m-%d"; // Default
	private Boolean isCustom = false;

	@Autowired
	private PatientService patientService;
	
	public String getCustomEndDate() {
		return customEndDate;
	}

	public void setCustomEndDate(String customEndDate) {
		this.customEndDate = customEndDate;
	}


	public Boolean getIsCustom() {
		return isCustom;
	}

	public void setIsCustom(Boolean isCustom) {
		this.isCustom = isCustom;
	}
	
	public void setPattern(String pat){
		this.pattern = pat;
	}
	
	public String getPattern() {
		return pattern;
	}
		
	public Character getViewType() {
		return viewType;
	}

	public void setViewType(Character type) {
		this.viewType = type;
	}

	public TotalRegistrations getRegister() {
		return register;
	}

	public void setRegister(TotalRegistrations register) {
		this.register = register;
	}

	public String getCustomDate() {
		return customDate;
	}

	public void setCustomDate(String dailyDay) {
		this.customDate = dailyDay;
	}

	public String dashboard() {
		setIsCustom(true);
		setDefaultDate();
		return SUCCESS;
	}

	public String dailyReport() {
		
		try {

			setDefaultDate();
			setIsCustom(false);
			beforeAction();
			pager = patientService.viewAllByPagerAndDate(pager, this.customDate);
			pager = setActionContext(pager);
			setRegister(patientService.getTotals(RegTotal, this.customDate));
			// System.out.println(RegTotal.getTotal());

		} catch (Exception e) {
			addActionError("Exception occur");
			// logger
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String weeklyReport() {

		setDefaultDate();
		setIsCustom(false);
		return SUCCESS;
	}

	public String monthlyReport() {
		
		setDefaultDate();
		this.pattern = "%Y-%m";
		setIsCustom(false);
		this.customDate = this.customDate.substring(0, this.customDate.length() - 3);
		return SUCCESS;
	}

	
	public String annualReport() {
		setDefaultDate();
		this.pattern = "%Y";
		setIsCustom(false);		
		this.customDate = this.customDate.substring(0, this.customDate.length() - 6);
		return SUCCESS;
	}
	
	public String getEndDate(String start_Date, int days_to_add) {
		Calendar end = Calendar.getInstance();
		SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd");
		String end_Date = start_Date;
		try {

			end.setTime(endDate.parse(start_Date));
			end.add(Calendar.DAY_OF_MONTH, days_to_add);
			end_Date = endDate.format(end.getTime());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return end_Date;
	}

	public String getWeekStart(String custom_date) {
		Calendar start = Calendar.getInstance();
		SimpleDateFormat custom_format = new SimpleDateFormat("yyyy-MM-dd");
		String week_start = custom_date;
		int subDate[] = { -6, 0, -1, -2, -3, -4, -5 };

		try {
			start.setTime(custom_format.parse(week_start));
			start.add(Calendar.DAY_OF_MONTH, subDate[start.get(Calendar.DAY_OF_WEEK) - 1]);
			week_start = custom_format.format(start.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return week_start;
	}

	public List<Patient> getList() {
		List<Patient> list = null;
		if (getIsCustom()) {
			list = patientService.veiwAllBetweenDates(this.customDate, this.customEndDate);
		}else if (viewType == 'W') {
			int week = 7;
			list = patientService.veiwAllBetweenDates(getWeekStart(this.customDate),
					getEndDate(getWeekStart(this.customDate), week));
			
		}else {
			list = patientService.viewAllByDate(this.customDate);
		}
		
		return list;

	}
	
	public List<DistrictRegistrationMapper> getDistrictList(){

		List<DistrictRegistrationMapper> rList = null;
		if (getIsCustom()) {
			rList = patientService.viewAllBetweenRegDistricts(this.customDate, this.customEndDate);
		}else if (viewType == 'W') {
			int week = 7;
			rList = patientService.viewAllBetweenRegDistricts(getWeekStart(this.customDate), getEndDate(getWeekStart(this.customDate), week));
		}else {
			//System.out.println(this.pattern);
			rList = patientService.viewAllRegDistricts(this.customDate, this.pattern);
		}
		
		return rList;
	}

	public String patientReportPdf() {

		try {
			setDefaultDate();
			List<Patient> patients = this.getList();
			List<DistrictRegistrationMapper> districts = this.getDistrictList();

				
			if (getIsCustom()) {
				setRegister(patientService.getBetweenTotals(RegTotal, this.customDate, this.customEndDate));
			}else if (getViewType() == 'W') {
				setRegister(patientService.getBetweenTotals(RegTotal, getWeekStart(this.customDate),
						getEndDate(getWeekStart(this.customDate), 7)));
				// System.out.println(patientService.getBetweenTotals(RegTotal, this.customDate,
				// getEndDate(this.customDate, 7)));
			} else {
				setRegister(patientService.getTotals(RegTotal, this.customDate));
			}

			PdfReportInformation pdfReporttInformation = new PdfReportInformation();
			ByteArrayOutputStream baos = pdfReporttInformation.createPdf(patients, districts, this.register, this.customDate);

			return download(baos, "Daily");

		} catch (DocumentException e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		} catch (IOException e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}

	}

	private String download(ByteArrayOutputStream baos, String prefix) {
		byte[] pdfFile = baos.toByteArray();
		setFileInputStream(new ByteArrayInputStream(pdfFile));

		String dateString = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
		setFileName(prefix + dateString + ".pdf");
		return SUCCESS;
	}

	public void setDefaultDate() {
		if (this.customDate == null) {
			this.customDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		}
		
		if (this.customEndDate == null) {
			this.customEndDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		}
	}

	
	

}
