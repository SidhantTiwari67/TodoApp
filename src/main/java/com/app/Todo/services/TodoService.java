package com.app.Todo.services;

import com.app.Todo.models.Todo;
import com.app.Todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void createTodo(String title) {
        Todo todo= new Todo();
        todo.setCompleted(false);
        todo.setTitle(title);
        todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public void toggleTodo(Long id) {
        Optional<Todo> todoOptional =todoRepository.findById(id);
        Todo todo=todoOptional.get();
        todo.setCompleted(!todo.isCompleted());
        todoRepository.save(todo);
    }
}
