package com.doerit.model.criteria;

import java.util.ArrayList;
import java.util.List;

import com.doerit.util.Pager;

public class SearchCriteria {

	protected Pager pager;
	protected String client;
	protected String business;
	protected String owner;
	protected String clientType;
	protected Byte status;
	protected List<String> states;
	protected Object searcher;
	protected Object extra;
	
	public Pager getPager() {
		return pager;
	}
	
	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}	

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public List<String> getStates() {
		return states;
	}

	public void setStates(List<String> states) {
		this.states = states;
	}

	public void addState(String value) {
		if(this.states == null) this.states = new ArrayList<String>();
		this.states.add(value);		
	}

	public Object getSearcher() {
		return searcher;
	}

	public void setSearcher(Object searcher) {
		this.searcher = searcher;
	}

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
