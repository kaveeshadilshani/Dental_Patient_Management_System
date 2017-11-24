package com.doerit.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Searcher extends UrlWrapper {
	
	private static final long serialVersionUID = 1L;
	
	private Date fromDate;
	private Date toDate;
	protected String state;
	private String extra;
	
	private boolean enableDefaultDate;
	private boolean enableDates;
	private boolean enableList;	
	private List<? extends Object> list;
	
	public Searcher() {
		this.fromDate = null;
		this.toDate = null;
		this.state = null;
		this.setExtra(null);
		this.enableDefaultDate = false;
		this.enableDates = true;
		this.enableList = true;
		this.list = new ArrayList<Object>();
	
		this.actionName = "search";
	}
	
	public Date getFromDate() {
		if(fromDate == null && isEnableDefaultDate())
			setFromDate(new Date());			
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(fromDate); 
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH),0,0,0);
		this.fromDate = c.getTime();
	}

	public Date getToDate() {
		if(toDate == null && isEnableDefaultDate())
			setToDate(new Date());
		return toDate;
	}

	public void setToDate(Date toDate) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(toDate); 
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE),0,0,0);
		c.add(Calendar.DATE, 1);
		c.add(Calendar.MINUTE, -1);
		this.toDate = c.getTime();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public boolean isEnableDefaultDate() {
		return enableDefaultDate;
	}

	public void setEnableDefaultDate(boolean enableDefaultDate) {
		this.enableDefaultDate = enableDefaultDate;
	}

	public boolean isEnableDates() {
		return enableDates;
	}

	public void setEnableDates(boolean enableDates) {
		this.enableDates = enableDates;
	}

	public boolean isEnableList() {
		return enableList;
	}

	public void setEnableList(boolean enableList) {
		this.enableList = enableList;
	}
	
	public List<? extends Object> getList() {
		return list;
	}

	public void setList(List<? extends Object> list) {
		this.list = list;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
}