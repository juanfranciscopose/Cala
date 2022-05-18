package com.cala.model.vo.configurations;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.configurations.AgeGroup;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.global.AbstractVo;

public class AgeGroupVo extends AbstractVo implements Filterable{
	
	private String name;
	
	private int ageMax;
	
	private int ageMin;
	
	private boolean active;

	public AgeGroupVo() {}
	
	public AgeGroupVo(AgeGroup ageGroup) {
		setId(ageGroup.getId());
		setName(ageGroup.getName());
		setAgeMax(ageGroup.getAgeMax());
		setAgeMin(ageGroup.getAgeMin());
		setActive(ageGroup.isActive());
	}
	
	public AgeGroupVo(String name, int ageMax, int ageMin, boolean active) {
		this.name = name;
		this.ageMax = ageMax;
		this.ageMin = ageMin;
		this.active = active;
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
	
	public static List<AgeGroupVo> createListVo(List<AgeGroup> list) {
		return list.stream().map(config -> new AgeGroupVo(config)).collect(Collectors.toList());
	}

	public static AgeGroupVo createVo(AgeGroup config) {
		if (config != null) {
			return new AgeGroupVo(config);
		}
		return null;
	}
		
}
