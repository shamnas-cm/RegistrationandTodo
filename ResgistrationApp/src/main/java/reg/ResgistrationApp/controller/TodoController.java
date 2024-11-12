package reg.ResgistrationApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reg.ResgistrationApp.model.Todo;
import reg.ResgistrationApp.service.TodoService;
import reg.ResgistrationApp.util.TodoDto;
@CrossOrigin(origins = "https://shamnasproject.netlify.app")
@RestController
public class TodoController {
	@Autowired
	TodoService service;
   
	@PostMapping("/addTodo")
	public ResponseEntity<Todo> saveTodo(@RequestBody TodoDto todo) {
		Todo work=service.saveTodo(todo);
		return new ResponseEntity<Todo>(work,HttpStatus.OK);
		
	}
	@PutMapping("/complete/{id}")
	public ResponseEntity<Todo> markAsCompleted(@PathVariable Long id) {
	    Todo updatedTodo = service.markAsCompleted(id);
	    return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Todo> updateTodo(
	        @PathVariable Long id,
	        @RequestBody TodoDto todoDto) {
	    Todo updatedTodo = service.updateTodo(id, todoDto);
	    return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
	    service.deleteTodoById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Todo>> getAllTodos() {
	    List<Todo> todos = service.getAllTodos();
	    return new ResponseEntity<>(todos, HttpStatus.OK);
	}
	@GetMapping("/completed")
	public ResponseEntity<List<Todo>> getCompletedTodos() {
	    List<Todo> completedTodos = service.getCompletedTodos();
	    return new ResponseEntity<>(completedTodos, HttpStatus.OK);
	}
	@GetMapping("/incomplete")
	public ResponseEntity<List<Todo>> getIncompleteTodos() {
	    List<Todo> incompleteTodos = service.getIncompleteTodos();
	    return new ResponseEntity<>(incompleteTodos, HttpStatus.OK);
	}


	
}
