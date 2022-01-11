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
import com.cala.model.vo.filters.IdeologyVo;

@Entity
@Table(name="filters_ideology")
public class Ideology implements Auditable, Filterable{
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

	public Ideology() {}
	
	public Ideology(String name, boolean active) {
		setName(name);
		setActive(active);
	}

	public Ideology(IdeologyVo filterVo) {
		setName(filterVo.getName());
		setActive(filterVo.isActive());
	}
	
	@Override
	public String generateLog(String method) {
		return method + " ->" + " {id:" + getId() + ", ideología:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static List<Ideology> createList(List<IdeologyVo> list) {
		if (list!= null) {
			return list.stream().map(filter -> new Ideology(filter)).collect(Collectors.toList());
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
