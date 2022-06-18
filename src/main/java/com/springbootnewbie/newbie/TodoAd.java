package com.springbootnewbie.newbie;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TodoAd {
	
	public TodoAd() {
		// TODO Auto-generated constructor stub
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TodoNotFound.class)
	String Todonotfound(TodoNotFound ex) {
		return ex.getMessage();
	}
}
