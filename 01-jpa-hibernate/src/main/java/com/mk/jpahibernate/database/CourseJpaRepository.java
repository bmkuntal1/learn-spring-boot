package com.mk.jpahibernate.database;

import com.mk.jpahibernate.models.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Course getById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public void delete(long id) {
        var course = entityManager.find(Course.class, id);
        if (course != null) {
            entityManager.remove(course);
        }
    }
}
