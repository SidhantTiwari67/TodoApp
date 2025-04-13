package com.app.Todo.controllers;

import com.app.Todo.models.Todo;
import com.app.Todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping
    public String getTodos(Model model){
        List<Todo> todos= todoService.getAllTodos();
        model.addAttribute("todos",todos);
        return "todos";
    }
    @PostMapping
    public String createTodo(@RequestParam String title){
        todoService.createTodo(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTodo(@PathVariable Long id){
        todoService.toggleTodo(id);
        return "redirect:/";
    }
}
