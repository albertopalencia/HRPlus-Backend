package com.HRPlus.space.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HRPlus.space.entities.Todo;
import com.HRPlus.space.repositories.ITodoRepository;

@RestController
public class TodoController {
	
	@Autowired
    ITodoRepository todoRepository;

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }
    
    
//
//    @GetMapping(value="/todos/{id}")
//    public ResponseEntity<Todo> getTodoById(@PathVariable("id") String id) {
//        return todoRepository.findAllById(id)
//                .map(todo -> ResponseEntity.ok().body(todo))
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PutMapping(value="/todos/{id}")
//    public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id,
//                                           @Valid @RequestBody Todo todo) {
//        return todoRepository.findById(id)
//                .map(todoData -> {
//                    todoData.setTitle(todo.getTitle());
//                    todoData.setCompleted(todo.isCompleted());
//                    Todo updatedTodo = todoRepository.save(todoData);
//                    return ResponseEntity.ok().body(updatedTodo);
//                }).orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping(value="/todos/{id}")
//    public ResponseEntity<?> deleteTodo(@PathVariable("id") String id) {
//        return todoRepository.findById(id)
//                .map(todo -> {
//                    todoRepository.deleteById(id);
//                    return ResponseEntity.ok().build();
//                }).orElse(ResponseEntity.notFound().build());
//    }

}
