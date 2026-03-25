package kaitos.desafiotodo.to_do.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kaitos.desafiotodo.to_do.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
