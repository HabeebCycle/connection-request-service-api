package com.mport.habeeb.connectionaccess.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IpAddressNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3195881621063515671L;

	public IpAddressNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
