package kaitos.desafiotodo.to_do.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kaitos.desafiotodo.to_do.service.TodoService;
import kaitos.desafiotodo.to_do.entity.Todo;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService service;

    public TodoController (TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> salvarTodos(@RequestBody Todo todo) {
        service.saveTodo(todo);
        return service.getAllTodos();
    }

    @PostMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    @PutMapping
    public List<Todo> updateTodo(@RequestBody Todo todo) {
        service.saveTodo(todo);
        return service.getAllTodos();
    }

    @DeleteMapping("{id}")
    public List<Todo> deleteTodo(@PathVariable long id) {
        service.deleteTodos(id);
        return getAllTodos();
    }
}
