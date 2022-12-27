package com.bmkuntal.springbootjsp.database;

import com.bmkuntal.springbootjsp.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
