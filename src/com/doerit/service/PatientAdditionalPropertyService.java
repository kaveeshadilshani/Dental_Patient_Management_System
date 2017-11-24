package com.doerit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doerit.dao.PatientAdditionalPropertyMapper;
import com.doerit.model.PatientAdditionalProperty;

@Service
public class PatientAdditionalPropertyService {

	@Autowired
	private PatientAdditionalPropertyMapper patientAdditionalPropertyMapper;
	
	public PatientAdditionalProperty viewById(String id) {
		return patientAdditionalPropertyMapper.selectByPrimaryKey(id);
	}
	
	public int save(PatientAdditionalProperty property) {
		return patientAdditionalPropertyMapper.insert(property);
	}
	
	public int update(PatientAdditionalProperty property) {
		return patientAdditionalPropertyMapper.updateByPrimaryKeySelective(property);
	}
	
	public List<PatientAdditionalProperty> viewByPatientId(String patientId) {
		return patientAdditionalPropertyMapper.findByPatientId(patientId);
	}

}
