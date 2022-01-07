package com.cala.model.vo.filters.generics;

import com.cala.model.vo.global.AbstractVo;

public abstract class GenericFilterVo extends AbstractVo {
	
	private String name;
	
	private boolean active;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
