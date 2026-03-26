package kaitos.desafiotodo.to_do.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kaitos.desafiotodo.to_do.entity.Todo;
import kaitos.desafiotodo.to_do.repository.TodoRepository;
import kaitos.desafiotodo.to_do.exception.BadRequestException;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> saveTodo(Todo todo) {
        todoRepository.save(todo);
        return getAllTodos();
    }

    public List<Todo> getAllTodos() {
        Sort sort = Sort.by(Direction.DESC, "prioridade").and(Sort.by(Direction.ASC, "nome"));
        return todoRepository.findAll(sort);
    }

    public List<Todo> updateTodos(Todo todo, long id) {
        todoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            todo.setId(id);
            todoRepository.save(todo);
        }, () -> {
            throw new BadRequestException("ID " + id + " não encontrado");
        });
        return getAllTodos();
    }

    public List<Todo> deleteTodos(long id) {
        todoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            todoRepository.deleteById(id);
        }, () -> {
            throw new BadRequestException("ID " + id + " não encontrado");
        });
        return getAllTodos();
    }
}
