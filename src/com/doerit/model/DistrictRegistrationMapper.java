package com.doerit.model;

public class DistrictRegistrationMapper {
	
	private String district;
	private Integer districtTotal;
	
	public void setDistrict(String dst) {
		this.district = dst;
	}
	
	public void setDistrictTotal(Integer tot) {
		this.districtTotal = tot;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public Integer getDistrictTotal() {
		return districtTotal;
	}

	public String toString() {
		return "Districts [district=" + district + ", total=" + districtTotal  + "]";
	}
	
}
