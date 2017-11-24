package com.doerit.action.patient;

import org.springframework.beans.factory.annotation.Autowired;

import com.doerit.action.AbstractManagementAction;
import com.doerit.model.Patient;
import com.doerit.model.PatientGuardianWithBLOBs;
import com.doerit.service.PatientGuardianService;
import com.doerit.service.PatientService;

public class PatientGuardianAction extends AbstractManagementAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired PatientService patientService;
	@Autowired PatientGuardianService patientGuardianService;

	private PatientGuardianWithBLOBs patientGuardian;
	private String patientId;
	private Patient patient;

	public String form() {
		if(patientId != null) {
			patient = patientService.viewById(patientId);
			System.out.println(patient);
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	public String view() {
		if(getId() != null) {
			patientGuardian = patientGuardianService.viewById(getId());
		}
		
		return SUCCESS;
	}
	
	public String save() {
		
		if(patientGuardian != null) {
			if(patientGuardian.getId() == null) {
				patientGuardian.setId(generatePrimaryKey());
				patientGuardian.setPatientId(patientId);
				addInsertSettings(patientGuardian);
				patientGuardianService.save(patientGuardian);
			}else {
				patientGuardian.setPatientId(patientId);
				addUpdateSettings(patientGuardian);
				patientGuardianService.update(patientGuardian);
			}
		} else {
			return INPUT;
		}
		
		return SUCCESS;
	}
	
	public String edit() {
		return SUCCESS;
	}
	
	public String delete() {
		return SUCCESS;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public PatientGuardianWithBLOBs getPatientGuardian() {
		return patientGuardian;
	}

	public void setPatientGuardian(PatientGuardianWithBLOBs patientGuardian) {
		this.patientGuardian = patientGuardian;
	}
	
}
