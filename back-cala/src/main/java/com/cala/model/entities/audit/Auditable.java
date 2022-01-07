package com.cala.model.entities.audit;

public interface Auditable {
	public String generateLog(String method);
}
