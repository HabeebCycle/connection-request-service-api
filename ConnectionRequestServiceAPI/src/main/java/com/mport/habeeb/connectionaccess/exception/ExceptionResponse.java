package com.mport.habeeb.connectionaccess.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {

	private Date timeStamp;
	private String message;
	private String details;
	private HttpStatus statusCode;
	
	public ExceptionResponse() {
		
	}
	
	public ExceptionResponse(Date timeStamp, String message, String details, HttpStatus statusCode) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
		this.statusCode = statusCode;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	
}
