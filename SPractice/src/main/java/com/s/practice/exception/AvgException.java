package com.s.practice.exception;

public abstract class AvgException extends Exception {

	public AvgException(Throwable cause) {
		super(cause);
	}
	
	 public AvgException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
