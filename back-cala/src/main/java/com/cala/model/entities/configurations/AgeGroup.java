package com.cala.model.entities.configurations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.vo.configurations.AgeGroupVo;

@Entity
@Table(name="age_group")
public class AgeGroup implements Auditable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="age_max", nullable = false)
	private int ageMax;
	
	@Column(name="age_min", nullable = false)
	private int ageMin;
		
	@Column(name = "active", nullable = false)
	private boolean active;
	
	@Column(name="code", nullable = false, unique = true)
	private String code;
		
	public AgeGroup() {}
	
	public AgeGroup(String name, int ageMax, int ageMin, boolean active, String code) {
		this.name = name;
		this.ageMax = ageMax;
		this.ageMin = ageMin;
		this.active = active;
		this.code = code;
	}

	public AgeGroup(AgeGroupVo config) {
		this.name = config.getName();
		this.ageMax = config.getAgeMax();
		this.ageMin = config.getAgeMin();
		this.active = config.isActive();
		this.code = config.getCode();
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

	public int getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(int ageMax) {
		this.ageMax = ageMax;
	}

	public int getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	private String activeToString() {
		return isActive() ? "Si" : "No";
	}

	@Override
	public String generateLog(String method) {
		return method + " ->" +" {id:" + getId() + ", nombre:" + getName() + ", edad máxima: " + getAgeMax() + 
				", edad mínima: "+ getAgeMin() +", activo: " + activeToString() + "}";
	}

	public static AgeGroup create(AgeGroupVo ageGroup) {
		if (ageGroup != null) {
			return new AgeGroup(ageGroup);	
		}
		return null;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
