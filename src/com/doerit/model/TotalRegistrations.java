package com.doerit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TotalRegistrations {

	private Integer totalCount;
	private Integer maleCount;
	private Integer femaleCount;
	private Integer childCount;
	private List<Integer> totalCounts;
	
	private Integer DEFAULT_VALUE = 0;
	
	
	public Integer getTotal() {
		return totalCount;
	}
	
	public Integer getMaleTotal() {
		return maleCount;
	}
	
	public Integer getFemaleTotal() {
		return femaleCount;
	}
	
	public Integer getChildTotal() {
		return childCount;
	}
	
	public List<Integer> getTotalCounts(){
		return totalCounts;
	}

	public void setTotal(Integer total) {
		this.totalCount = total != null? total: DEFAULT_VALUE;
	}
	
	public void setMaleTotal(Integer total) {
		this.maleCount = total != null? total: DEFAULT_VALUE;
	}
	
	public void setFemaleTotal(Integer total) {
		this.femaleCount = total != null? total: DEFAULT_VALUE;
	}

	public void setChildTotal(Integer total) {
		this.childCount = total != null? total: DEFAULT_VALUE;
	}
	
	public void setTotalCounts(List<Integer> l) {
		this.totalCounts = l;
	}
	
	@Override
	public String toString() {
		return "TotalRegistrations [ total="+ totalCount + ", maleTotal="+ maleCount + ", femaleTotal=" + femaleCount +
				", childTotal=" + childCount + "]";
	}
}