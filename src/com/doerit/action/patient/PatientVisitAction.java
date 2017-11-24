package com.doerit.action.patient;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doerit.action.AbstractManagementAction;
import com.doerit.dao.PatientMapper;
import com.doerit.dao.PatientVisitMapper;
import com.doerit.exception.SessionNotExist;
import com.doerit.model.Patient;
import com.doerit.model.PatientVisit;
import com.doerit.service.DepartmentService;
import com.doerit.service.PatientService;
import com.doerit.service.PatientVisitService;
import com.doerit.util.Pager;

;

public class PatientVisitAction extends AbstractManagementAction{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired PatientVisitService patientVisitService;
	@Autowired PatientService patientService;
	@Autowired DepartmentService districtService;
	
	private Patient patient;
	private PatientVisit patientVisit;
	//private Pager visitsPager;
	//private List<PatientVisit> visits;
	private String searchKey;
	private String searchWord;
	private String visitComment;
	private String patientId;
	
	
	public String view() {
		if(this.searchWord != null && !this.searchWord.equals("")) {
			patient = patientService.viewBySerial(this.searchWord);
			if(patient != null) {
				setPatient(patient);
				beforeAction();
				pager = patientVisitService.viewByPatientId(pager, patient.getSerialNumber());
				pager = setActionContext(pager);
			}
			
			//setVisitsPager(patientVisitService.viewByPatientId(pager, patient.getSerialNumber()));
			
			//System.out.println(patientVisitService.viewByPatientId(patient.getId()));
		} 
		return SUCCESS;
	}
	
	public String addVisit() {		
		
		try {
			if(this.patientId != null && !getPatientId().equals("")) {
				System.out.println(getPatientId());
				patient = patientService.viewBySerial(getPatientId());
				setPatient(patient);
				setPatientVisit(new PatientVisit());
				
				beforeAction();
				
				patientVisit.setComment(this.visitComment);
				patientVisit.setId(generatePrimaryKey());
				patientVisit.setPatientId(getPatientId());
				patientVisit.setDepartmentId(getSessionUser().getDepartment());
				patientVisit.setInsertDatetime(new Date());
				patientVisit.setInsertUserId(getSessionUserId());
				patientVisitService.save(patientVisit);
				
				pager = patientVisitService.viewByPatientId(pager, patient.getSerialNumber());
				pager = setActionContext(pager);
			}		
			
		} catch (SessionNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public String getSearchKey() {
		return searchKey;
	}


	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}


	public String getSearchWord() {
		return searchWord;
	}


	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}


	public String getVisitComment() {
		return visitComment;
	}


	public void setVisitComment(String visitComment) {
		this.visitComment = visitComment;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public PatientVisit getPatientVisit() {
		return patientVisit;
	}

	public void setPatientVisit(PatientVisit patientVisit) {
		this.patientVisit = patientVisit;
	}

}
