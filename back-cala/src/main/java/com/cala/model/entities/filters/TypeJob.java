package com.cala.model.entities.filters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.TypeJobVo;

@Entity
@Table(name="filters_type_job")
public class TypeJob implements Auditable, Filterable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "active", nullable = false)
	private boolean active;
	
	@Column(name="name", nullable = false, unique = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeJob() {}
	
	public TypeJob(String name, boolean active) {
		setName(name);
		setActive(active);
	}
	
	public TypeJob(TypeJobVo filterVo) {
		setName(filterVo.getName());
		setActive(filterVo.isActive());
	}
	
	@Override
	public String generateLog(String method) {
		return method + " ->" + " {id:" + getId() + ", tipo de empleo:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static TypeJob create(TypeJobVo typeJobVo) {
		if (typeJobVo != null) {
			return new TypeJob(typeJobVo);
		}
		return null;
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

	
}
