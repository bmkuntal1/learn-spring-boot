package com.mk.jpahibernate.database;

import com.mk.jpahibernate.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {
    List<Course> findByAuthor(String author);
}
