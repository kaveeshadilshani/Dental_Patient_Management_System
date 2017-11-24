package com.doerit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doerit.dao.DistrictMapper;
import com.doerit.model.District;

@Service
public class DistrictService {

	@Autowired private DistrictMapper districtMapper;
	
	public List<District> viewAll() {
		return districtMapper.findAll();
	}
		
}
