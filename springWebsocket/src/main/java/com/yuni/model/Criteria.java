package com.yuni.model;

import lombok.Data;


public class Criteria {
	
	// page -> 변수 -> 현재 페이지	
	// perPageNum -> 변수 -> 페이지당 몇 개 보여줄지 지정
	// startPage -> 변수가 아니라 limit에서 1번째 값 지정하는데 계산한다!
	
	private int page;
	private int perPageNum;
	private int pageStart;
	
	
	public Criteria() {
		this(1,10);
	}
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
		this.pageStart = (this.page - 1) * perPageNum;
	}

	public void setPage(int page) {
		if(page<=0) {
			this.page=1;
			return;
		}
		this.page=page;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0|| perPageNum>100) {
			this.perPageNum=10;
			return;
		}
		this.perPageNum=perPageNum;
	}

	public int getPage() {
		return page;
	}

	public int getPageStart() {
		return pageStart;
	}

	public int getPerPageNum() {
		
		return this.perPageNum;
	}
	
	public void setPageStart(int pageStart) {
		pageStart = (this.page - 1) * perPageNum;
		this.pageStart=pageStart;
	}
	
	


}
