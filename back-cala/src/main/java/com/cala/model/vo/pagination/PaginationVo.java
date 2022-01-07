package com.cala.model.vo.pagination;

public class PaginationVo {
	//page that we want - start at 0
	private int page;
	
	//how many rows
	private int size;
	
	public PaginationVo(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
}
