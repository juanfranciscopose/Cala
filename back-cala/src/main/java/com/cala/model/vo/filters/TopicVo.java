package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class TopicVo  extends GenericFilterVo{

	public TopicVo() {}
	
	public TopicVo(Filterable filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
	}

	public TopicVo(String name, boolean active) {
		setName(name);
		setActive(active);
	}

	public static TopicVo createVo(Filterable topic) {
		if (topic != null) {
			return new TopicVo(topic);
		}
		return null;
	}
	
	public static List<TopicVo> createListVo(List<Filterable> topics){
		if (topics!= null) {
			return topics.stream().map(TopicVo::new).collect(Collectors.toList());	
		}
		return null;
	}

	public static TopicVo createVo(String name, boolean active) {
		if (name != null) {
			return new TopicVo(name, active);
		}
		return null;
	}
	
}
