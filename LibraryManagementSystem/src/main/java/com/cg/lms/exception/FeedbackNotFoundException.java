package com.cg.lms.exception;

public class FeedbackNotFoundException extends RuntimeException{
	public FeedbackNotFoundException() {
		
	}
	
	public FeedbackNotFoundException(String message) {
		super(message);
	}
}
