package com.cala.model.dto.global;

import java.util.List;

import com.cala.util.messages.MessageSuccess;

public class ResponseDto {
	private Boolean ok;
	private Object json;
	private String message;
	private List<String> messages;
	
	public ResponseDto() {}
	
	public ResponseDto(Boolean ok) {
		setOk(ok);
	}
	
	public ResponseDto(Boolean ok, Object json) {
		this(ok);
		setJson(json);
	}
	
	public ResponseDto(Boolean ok, Object json, String message) {
		this(ok, json);
		setMessage(message);
	}
	
	public ResponseDto(Boolean ok, Object json, String message, List<String> messages) {
		this(ok, json, message);
		setMessages(messages);
	}
	
	public static ResponseDto ok(){
		return new ResponseDto(true, null, MessageSuccess.EXITO);
	}
	
	public static ResponseDto ok(Object json){
		return new ResponseDto(true, json, MessageSuccess.EXITO);
	}
	
	public static ResponseDto error(String message){
		return new ResponseDto(false, null, message);
	}
	
	public static ResponseDto error(){
		return new ResponseDto(false, null, null);
	}
	
	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	public Object getJson() {
		return json;
	}

	public void setJson(Object json) {
		this.json = json;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
