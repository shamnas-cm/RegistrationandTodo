package reg.ResgistrationApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reg.ResgistrationApp.model.Todo;
import reg.ResgistrationApp.repositary.TodoRepositary;
import reg.ResgistrationApp.util.TodoDto;

@Service
public class TodoService {
	@Autowired
     TodoRepositary repo;
     

	
	public Todo saveTodo(TodoDto todo) {
		Todo todo1=new Todo();
		todo1.setDescription(todo.getDescription());
		todo1.setTitle(todo.getTitle());
		todo1.setStatus("incomplete");
		
		return repo.save(todo1);
	}



	 public Todo markAsCompleted(Long id) {
	        Todo todo = repo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
	        
	        todo.setStatus("completed");
	        return repo.save(todo);
	    }



	 public Todo updateTodo(Long id, TodoDto todoDto) {
	        Todo todo = repo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
	        
	        todo.setTitle(todoDto.getTitle());
	        todo.setDescription(todoDto.getDescription());
	        return repo.save(todo);
	    }



	 public void deleteTodoById(Long id) {
	        if (!repo.existsById(id)) {
	            throw new RuntimeException("Todo not found with id: " + id);
	        }
	        repo.deleteById(id);
	    }



	 public List<Todo> getAllTodos() {
	        return repo.findAll();
	    }



	 public List<Todo> getCompletedTodos() {
	        return repo.findByStatus("completed");
	    }



	 public List<Todo> getIncompleteTodos() {
	        return repo.findByStatusNot("completed");
	    }

	 

}
