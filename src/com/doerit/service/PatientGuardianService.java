package com.doerit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doerit.dao.PatientGuardianMapper;
import com.doerit.model.PatientGuardianWithBLOBs;

@Service
public class PatientGuardianService {

	@Autowired
	private PatientGuardianMapper patientGuardianMapper;
	
	public PatientGuardianWithBLOBs viewById(String id) {
		return patientGuardianMapper.selectByPrimaryKey(id);
	}
	
	public int save(PatientGuardianWithBLOBs guardian) {
		return patientGuardianMapper.insert(guardian);
	}
	
	public int update(PatientGuardianWithBLOBs property) {
		return patientGuardianMapper.updateByPrimaryKeySelective(property);
	}
	
	public List<PatientGuardianWithBLOBs> viewByPatientId(String patientId) {
		return patientGuardianMapper.findByPatientId(patientId);
	}

}
