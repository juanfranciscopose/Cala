package com.cala.model.entities.filters.filterable;

public interface Filterable {
	public void setName(String name);
	public String getName() ;
	public Long getId();
	public void setId(Long id);
	public boolean isActive();
	public void setActive(boolean active);
}