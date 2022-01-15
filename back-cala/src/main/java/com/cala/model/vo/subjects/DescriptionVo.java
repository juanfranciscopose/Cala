package com.cala.model.vo.subjects;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.subjects.Description;
import com.cala.model.vo.global.AbstractVo;

public class DescriptionVo extends AbstractVo{
	
	private String description;
	
	private boolean status;
	
	private Date stamp;
	
	public static List<DescriptionVo> createListVo(List<Description> list) {
		if (list!= null) {
			return list.stream().map(description -> new DescriptionVo(description)).collect(Collectors.toList());
		}
		return null;
	}

	public static DescriptionVo createVo(Description description) {
		if (description != null) {
			return new DescriptionVo(description);
		}
		return null;
	}
	
	public DescriptionVo() {}
	
	public DescriptionVo(Description description) {
		this.description = description.getDescription();
		this.status = description.isStatus();
		this.stamp = description.getStamp();
	}
			
	public DescriptionVo(String description, boolean status, Date stamp) {
		this.description = description;
		this.status = status;
		this.stamp = stamp;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getStamp() {
		return stamp;
	}

	public void setStamp(Date stamp) {
		this.stamp = stamp;
	}
	
}
