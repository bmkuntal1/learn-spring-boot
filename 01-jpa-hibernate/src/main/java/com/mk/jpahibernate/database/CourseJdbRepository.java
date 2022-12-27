package com.mk.jpahibernate.database;

import com.mk.jpahibernate.models.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbRepository {
    private JdbcTemplate springJdbcTemplate;
    public CourseJdbRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }

    public Course getById(long id){

       var course= springJdbcTemplate.
                queryForObject("select * from course where id=?", new BeanPropertyRowMapper<>(Course.class), id);
       return course;
    }

    public void insert(Course course){

        springJdbcTemplate.
                update("insert into course(id, name, author) values(?,?,?)",
                        course.getId(), course.getName(), course.getAuthor());



        //springJdbcTemplate.update("insert into course(id, name, author) values(2, 'Learn Azure', 'in28minute')");
    }

    public void delete(long id){

        springJdbcTemplate.
                update("delete from course where id=?", id);
    }
}
