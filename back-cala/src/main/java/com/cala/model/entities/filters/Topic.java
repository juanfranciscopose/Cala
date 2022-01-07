package com.cala.model.entities.filters;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.TopicVo;

@Entity
@DiscriminatorValue(value = "TOPIC")
public class Topic extends GenericFilter implements Auditable{
	
	public Topic () {}
	
	public Topic(TopicVo filterVo) {
		setName(filterVo.getName());
		setActive(filterVo.isActive());
	}
	
	public Topic(String name, boolean active) {
		setName(name);
		setActive(active);
	}
	
	@Override
	public String generateLog() {
		return "{id:" + getId() + ", temática:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static List<Topic> createList(List<TopicVo> list) {
		if (list!= null) {
			return list.stream().map(filter -> new Topic(filter)).collect(Collectors.toList());
		}
		return null;
	}

}
