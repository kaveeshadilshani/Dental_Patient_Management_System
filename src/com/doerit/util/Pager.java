package com.doerit.util;

import java.util.List;

public class Pager extends UrlWrapper {

	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_PAGE_SIZE = 15;
	public static final int DEFAULT_PAGE_START = 0;
	public static final int DEFAULT_PAGE_LIMIT = 15;

	private Integer start = 0; //default
	private Integer size = DEFAULT_PAGE_SIZE; //default
	private Integer limit = DEFAULT_PAGE_LIMIT;
	
	private Integer total;
	private List<? extends Object> list;
	
	public Pager() {
		super();
	}

	public Pager(int start, int size, int total, List<?> list) {
		super();
		this.start = start;
		this.size = size;
		this.total = total;
		this.list = list;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}
	
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<? extends Object> getList() {
		return list;
	}

	public void setList(List<? extends Object> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "Pager [start=" + start + ", size=" + size + ", total=" + total
				+ ", list=" + list.size() + "]";
	}
	
	public boolean isFirstEnable () {
		return start >= size;
	}
	
	public boolean isLastEnable() {
		return total > (start + size);
	}
	
	public boolean isPreviousEnable () {
		return start >= size;
	}
	
	public boolean isNextEnable() {
		return total > (start + size);
	}

	public Integer getPageNumber() {
		return (int) Math.ceil((start.doubleValue() + 1) / size.doubleValue());  //to avoid 0 index
	}
	
	public Integer getNumberOfPages() {
		return (int) Math.ceil(total.doubleValue() / size.doubleValue());
	}
	
	public Integer getActivePosition() {
		return (int) Math.ceil((limit.doubleValue() + 1) / 2);
	}
	
	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
