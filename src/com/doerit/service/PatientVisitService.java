package com.doerit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doerit.dao.PatientVisitMapper;
import com.doerit.model.PatientVisit;
import com.doerit.model.PatientVisitExample;
import com.doerit.util.Pager;
import com.doerit.util.State;

@Service
public class PatientVisitService {

	@Autowired private PatientVisitMapper patientVisitMapper;
	
	public List<PatientVisit> viewAll() {
		return patientVisitMapper.findAllActive(State.ACTIVE.getDatabaseValue());
	}
	
	public int save(PatientVisit patientVisit) {
		return patientVisitMapper.insert(patientVisit);
	}
	
	public int update(PatientVisit patientVisit) {
		return patientVisitMapper.updateByPrimaryKeySelective(patientVisit);
	}
	
	public PatientVisit viewById(String id) {
		return patientVisitMapper.selectByPrimaryKey(id);
	}
	
	public Pager viewByPatientId(Pager p, String id){
		PatientVisitExample sample = new PatientVisitExample();
		sample.createCriteria().andPatientIdEqualTo(id);
		p.setList(patientVisitMapper.selectByExample(sample));
		
		p.setList(patientVisitMapper.findByIdWithDepartment(id));
		p.setTotal(patientVisitMapper.countByExample(sample));
		
		return p;
	}
	
	
		
}
