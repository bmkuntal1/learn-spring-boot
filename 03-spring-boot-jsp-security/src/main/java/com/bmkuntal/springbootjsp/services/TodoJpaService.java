package com.bmkuntal.springbootjsp.services;

import com.bmkuntal.springbootjsp.database.TodoRepository;
import com.bmkuntal.springbootjsp.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoJpaService {

    @Autowired
    private TodoRepository repository;
    public List<Todo> findAll() {
        return repository.findAll();
    }


    public Todo findById(Long id) {
        return repository.findById(id).get();
    }

    public void add(Todo todo) {
        repository.save(todo);
    }

    public void update(Todo todo) {
        var _todo=findById(todo.getId());
        if(_todo!=null){
            _todo.setDescription(todo.getDescription());
            _todo.setTargetDate(todo.getTargetDate());
            _todo.setDone(todo.getDone());
        }
        repository.save(_todo);
    }

    public void delete(Long id) {

        var todo=findById(id);
        if(todo!=null){
            repository.delete(todo);
        }
    }
}
