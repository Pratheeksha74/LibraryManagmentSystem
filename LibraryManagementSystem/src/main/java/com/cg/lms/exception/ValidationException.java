package com.cg.lms.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException{
	
	List<String> messages = new ArrayList<String>();

	public ValidationException(List<String> messages) {
		super();
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

}
