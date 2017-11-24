package com.doerit.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doerit.dao.PatientMapper;
import com.doerit.model.DistrictRegistrationMapper;
import com.doerit.model.Patient;
import com.doerit.model.PatientExample;
import com.doerit.util.Pager;
import com.doerit.model.TotalRegistrations;
import com.doerit.util.State;

@Service
public class PatientService extends AbstractService {

	@Autowired
	private PatientMapper patientMapper;
	
	public Patient viewById(String id) {
		return patientMapper.viewByPrimaryKey(id);
	}
	
	public Patient viewBySerial(String serial) {
		PatientExample sample = new PatientExample();
		sample.createCriteria().andSerialNumberEqualTo(serial);
		
		if(!patientMapper.selectByExample(sample).isEmpty()){
			return patientMapper.selectByExample(sample).get(0);
		}
		return null;
		
	}
	
	public int save(Patient patient) {
		return patientMapper.insert(patient);
	}
	
	public int update(Patient patient) {
		return patientMapper.updateByPrimaryKeySelective(patient);
	}
	

	public Pager search(Pager p, String searchKey, String searchWord) { 
		
		List<Patient> patients = new ArrayList<>(0); 
		
		switch (searchKey) {
			case "serial":
				patients = patientMapper.searchBySerial("%" + searchWord + "%", State.ACTIVE.getDatabaseValue());
				break;
			case "surname":
				patients = patientMapper.searchBySurname("%" + searchWord + "%", State.ACTIVE.getDatabaseValue());
				break;
			case "firstname":
				patients = patientMapper.searchByFirstName("%" + searchWord + "%", State.ACTIVE.getDatabaseValue());
				break;
			case "nic":
				patients = patientMapper.searchByNic("%" + searchWord + "%", State.ACTIVE.getDatabaseValue());
				break;				
			case "mobile":
				patients = patientMapper.searchByMobile("%" + searchWord + "%", State.ACTIVE.getDatabaseValue());
				break;
			case "email":
				patients = patientMapper.searchByEmail("%" + searchWord + "%", State.ACTIVE.getDatabaseValue());
				break;
		}
		
		p.setList(patients);
		p.setTotal(patients.size());
		return p;
		
	}

	public int delete(String id) {
		return patientMapper.deleteByPrimaryKey(id);
	}
	
	public int findMonthlyCount(String yearMonthPrefix) {
		return patientMapper.findMonthlyRegistrations(yearMonthPrefix + "%");
	}
	
	public Pager viewAllByPagerAndStatus(Pager p, byte state) {
		
		p.setList(patientMapper.viewAllByStatus(p, state));
		p.setTotal(patientMapper.countAllByStatus(state));
		
		return p;
	}
	
	public Pager viewAllByPagerAndDate(Pager p, String date) {
		
			p.setList(patientMapper.viewAllByDateAndPage(p,date));
			p.setTotal(patientMapper.countAllByDate(date));
	
		return p;
	}
	
	public TotalRegistrations getTotals(TotalRegistrations t, String date) {
		
		t = patientMapper.viewTotalByDate(date);
		return t;
	}
	
	public TotalRegistrations getBetweenTotals(TotalRegistrations t, String s_date, String e_date) {
		
		t = patientMapper.viewTotalBetweenDates(s_date, e_date);
		return t;
	}
	
	public List<Patient> viewAllByDate(String date){
		return patientMapper.viewAllByDate(date);
	}
	
	public List<Patient> veiwAllBetweenDates(String start, String end){
		return patientMapper.viewBySelectedDate(start, end);
	}
	
	public List<DistrictRegistrationMapper> viewAllRegDistricts(String start, String pattern){
		return patientMapper.viewDistrictTotals(start, pattern);
	}
	
	public List<DistrictRegistrationMapper> viewAllBetweenRegDistricts(String start, String end){
		return patientMapper.viewDistrictBetweenTotals(start, end);
	}
}
