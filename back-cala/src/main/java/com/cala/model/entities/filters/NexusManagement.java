package com.cala.model.entities.filters;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.NexusManagementVo;

@Entity
@Table(name="filters_nexus_management")
public class NexusManagement implements Auditable, Filterable{
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
	
	public NexusManagement() {}
	
	public NexusManagement(String name, boolean active, String code) {
		setName(name);
		setActive(active);
		setCode(code);
	}
	
	public NexusManagement(NexusManagementVo filterVo) {
		setName(filterVo.getName());
		setActive(filterVo.isActive());
		setCode(filterVo.getCode());
	}
	
	@Override
	public String generateLog(String method) {
		return method + " ->" + " {id:" + getId() + ", nexo de gestión:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static List<NexusManagement> createList(List<NexusManagementVo> list) {
		if(list != null) {
			return list.stream().map(filter -> new NexusManagement(filter)).collect(Collectors.toList());
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
