package com.s.practice.exception;

public class FileReadException extends AvgException{

	public FileReadException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	public FileReadException( Throwable err) {
		super(null, err);
	}
}
