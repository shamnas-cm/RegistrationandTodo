import { Component, OnInit } from '@angular/core';
import { TodoServiceService } from './todo-service.service';
import { Todo } from '../models/todo.model';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  todos: Todo[] = [];
  newTodo: Todo = {id:0, title: '', description: '', status: 'incomplete' };

  constructor(private todoService: TodoServiceService) {}

  ngOnInit(): void {
    this.fetchTodos();
  }

  fetchTodos(): void {
    this.todoService.getTodos().subscribe(todos => {
      this.todos = todos;
    });
  }

  onSubmit(): void {
    if (this.newTodo.id === 0) {
      this.todoService.createTodo(this.newTodo).subscribe((data: Todo) => {
        this.todos.push(data);
        this.resetForm();
      });
    } else {
   
      this.todoService.updateTodo(this.newTodo).subscribe((data: Todo) => {
       
        const index = this.todos.findIndex(todo => todo.id === data.id);
        if (index > -1) {
          this.todos[index] = data; 
        }
        this.resetForm();
      });
    }
  }

  onEdit(todo: Todo): void {
    this.newTodo = { ...todo };
  }
  resetForm(): void {
    
    this.newTodo = { id: 0, title: '', description: '', status: 'incomplete' };
  }

  onDelete(id: number): void {
    this.todoService.deleteTodo(id).subscribe(() => {
      this.todos = this.todos.filter(todo => todo.id !== id);
    });
  }

  toggleStatus(id: number): void {
    this.todoService.toggleStatus(id).subscribe(updatedTodo => {
      const todo = this.todos.find(t => t.id === id);
      if (todo) {
        todo.status = updatedTodo.status; 
      }
    });
  }
}
