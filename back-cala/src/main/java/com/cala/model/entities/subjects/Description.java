package com.cala.model.entities.subjects;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cala.model.vo.subjects.DescriptionVo;

@Entity
@Table(name="descriptions")
public class Description {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="status", nullable = false)
	private boolean status;
	
	@Column(name="stamp", nullable = false)
	private Date stamp;
	
	public static List<Description> createList(List<DescriptionVo> list) {
		if (list!= null) {
			return list.stream().map(description -> new Description(description)).collect(Collectors.toList());
		}
		return null;
	}

	public Description() {}
	
	public Description(String description, boolean status, Date stamp) {
		this.description = description;
		this.status = status;
		this.stamp = stamp;
	}

	public Description(DescriptionVo descriptionVo) {
		this.description = descriptionVo.getDescription();
		this.status = descriptionVo.isStatus();
		this.stamp = descriptionVo.getStamp();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
