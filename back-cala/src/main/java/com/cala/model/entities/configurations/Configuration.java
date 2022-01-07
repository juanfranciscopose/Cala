package com.cala.model.entities.configurations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.vo.configurations.ConfigurationVo;

@Entity
@Table(name="configurations")
public class Configuration implements Auditable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="value", nullable = false)
	private String value;
		
	@Column(name = "name", nullable = false)
	private String name;
	
	public Configuration() {}
	
	public Configuration(ConfigurationVo config) {
		this.value = config.getValue();
		this.name = config.getName();
	}

	public Configuration(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String generateLog() {
		return "{id:" + getId() + ", nombre:" + getName() + ", valor: " + getValue() + "}";
	}
	
	
}
