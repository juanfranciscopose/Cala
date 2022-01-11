package com.cala.service.global;

import java.util.Collection;

import com.cala.exceptions.AppDataTypeValidationException;

public class DataTypeValidationService {

	public static <T> T checkNull(T o, String message) throws AppDataTypeValidationException {
		if (o == null) {
			throw new AppDataTypeValidationException(message);
		}
		return o;
	}
	
	public static Boolean checkString(String s, String message) throws AppDataTypeValidationException {
		if(s == null || s.isEmpty()){
			throw new AppDataTypeValidationException(message);
		}
		return true;
	}
	
	public static <T> Boolean checkCollection(Collection<T> c, String message) throws AppDataTypeValidationException {
		if(c == null || c.isEmpty()){
			throw new AppDataTypeValidationException(message);
		}
		return true;
	}
	
	public static void exceptionIf(Boolean exp, String message) throws AppDataTypeValidationException {
		if (exp) throw new AppDataTypeValidationException(message);
	}

	public static Boolean checkLong(Long l, String message) throws AppDataTypeValidationException {
		if(l == null || l <= 0){
			throw new AppDataTypeValidationException(message);
		}
		return true;
	}
	
	public static Boolean checkInteger(Integer i, String message) throws AppDataTypeValidationException {
		if(i == null || i < 0){
			throw new AppDataTypeValidationException(message);
		}
		return true;
	}
	
}
