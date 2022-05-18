package com.cala.controller.abm;

import org.springframework.http.ResponseEntity;

public interface I_GenericAbmController <T>{
	public ResponseEntity<?> create(T t);
	public ResponseEntity<?> update(T t);
	public ResponseEntity<?> list(int size, int page);
	public ResponseEntity<?> remove(Long id);
	public ResponseEntity<?> findById(Long id);
	
}
