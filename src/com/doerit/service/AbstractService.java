package com.doerit.service;

import com.doerit.util.Pager;

public class AbstractService {

	public static final String ITEM_NOT_FOUND_ERROR_MESSAGE = "Searched item not found : ";

	protected Pager pager;
	
	protected void initPager(Integer start, Integer size) {
		start = (start == null) ? 0 : start;
		size = (size == null || size == 0) ? Pager.DEFAULT_PAGE_SIZE: size;
		 
		this.pager = new Pager();
		
		this.pager.setStart(start);
		this.pager.setSize(size);
		
	}
}
