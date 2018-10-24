package com.s.practice.exception;

public class AverageServiceException extends AvgException {
	public AverageServiceException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	public AverageServiceException( Throwable err) {
		super(null, err);
	}
}
