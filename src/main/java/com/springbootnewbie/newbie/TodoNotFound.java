package com.springbootnewbie.newbie;

public class TodoNotFound extends RuntimeException{
	
	public TodoNotFound() {
		// TODO Auto-generated constructor stub
	}
	
	public TodoNotFound(long id) {
		super("could not find Todo "+ id);
	}

}
