package com.cala.model.entities.filters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.GenderVo;

@Entity
@Table(name="filters_gender")
public class Gender implements Auditable, Filterable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "active", nullable = false)
	private boolean active;
	
	@Column(name="name", nullable = false, unique = true)
	private String name;
	
	@Column(name="code", nullable = false, unique = true)
	private String code;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Gender() {}
	
	public Gender(GenderVo genderVo) {
		setName(genderVo.getName());
		setActive(genderVo.isActive());
		setCode(genderVo.getCode());
	}
	
	public Gender(String gender, boolean active, String code) {
		setName(gender);
		setActive(active);
		setCode(code);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	protected String activeToString() {
		return isActive() ? "Si" : "No";
	}

	@Override
	public String generateLog(String method) {
		return method + " ->" + " {id:" + getId() + ", género:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static Gender create(GenderVo gender) {
		if (gender != null) {
			return new Gender(gender);
		}
		return null;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}
}
