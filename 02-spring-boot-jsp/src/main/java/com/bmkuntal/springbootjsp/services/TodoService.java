package com.bmkuntal.springbootjsp.services;

import com.bmkuntal.springbootjsp.models.Todo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList<>();
    static {
        todos.add(new Todo(1l, "user@gmail.com", "Learn Java Spring Boot", LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(2l, "user@gmail.com", "Learn .Net Spring Boot", LocalDate.now().plusMonths(2), false));
        todos.add(new Todo(3l, "user@gmail.com", "Learn Node.Js Spring Boot", LocalDate.now().plusMonths(3), false));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo findById(Long id) {
        return todos.stream().filter(m -> m.getId()==id).findFirst().get();
    }

    public void add(Todo todo) {
        todos.add(todo);
    }

    public void update(Todo todo) {
        var _todo=findById(todo.getId());
        var index=todos.indexOf(_todo);
        todos.add(index, todo);
    }

    public void delete(Long id) {
        todos.removeIf(todo -> todo.getId()==id);
    }
}
