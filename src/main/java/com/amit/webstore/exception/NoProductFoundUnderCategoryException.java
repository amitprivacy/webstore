package com.amit.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason = "No Product Found Under this category")
public class NoProductFoundUnderCategoryException extends RuntimeException {

	private static final long serialVersionUID=3L;

	
}
