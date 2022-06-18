package com.springbootnewbie.newbie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class Todocontroller {
	private List<Todo>  todos = new ArrayList<>();
	private final AtomicLong counter = new AtomicLong ();
	
	public Todocontroller() {
		
	}
	
	@GetMapping("/todo")
	public List<Todo> getTodos1(){
		return todos;
	}
	
	@GetMapping("/todo/{id}")
	public Todo getTodos2(@PathVariable long id){
		return todos.stream().filter(result -> result.getId()== id).findFirst().orElseThrow(() -> new TodoNotFound(id));
	}
	
	@GetMapping("/todo/search")
	public String getTodos3(@RequestParam(defaultValue = "sumbenz") String name){
		return "Search: " + name;
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/todo")
	public void addtodo(@RequestBody Todo Todo ) {
		todos.add(new Todo(counter.getAndIncrement(),Todo.getName()));
	}
	@PutMapping("/todo/{id}")
	public void edittodo(@RequestBody Todo Todo, @PathVariable long id) {
		todos.stream().filter(result -> result.getId()== id).
		findFirst()
		.ifPresentOrElse(result -> {
			result.setName(Todo.getName());
		},()-> {
			throw new TodoNotFound(id);
		});
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/todo/{id}")
	public void Deletetodo(@RequestBody Todo Todo, @PathVariable long id) {
		todos.stream().filter(result -> result.getId()== id).
		findFirst()
		.ifPresentOrElse(result -> {
			todos.remove(result);
		},()-> {
			throw new TodoNotFound(id);
		});
	}
}


