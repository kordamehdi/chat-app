package com.creospan.chatapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)  // 404
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1788099566571092904L;

	public NotFoundException() {
		super("Resource not found");
	}
	
	public NotFoundException(String msg) {
		super(msg);
	}
}
