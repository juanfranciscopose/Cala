package com.cala.model.dto.filters;

import com.cala.model.entities.filters.filterable.Filterable;

public class FilterDto implements Filterable{

	private Long id;
	
	private String name;
	
	private boolean active;
	
	private String code;

	public FilterDto(Long id, String name, boolean active, String code) {
		setId(id);
		setName(name);
		setActive(active);
		setCode(code);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String generateLog(String type) {
		return "{id:" + getId() + ", filtro:" + getName() + ", activo: " + activeToString() +", tipo: "+type +"}";
	}

	private String activeToString() {
		return isActive() ? "Si" : "No";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
