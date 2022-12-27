package com.mk.jpahibernate;

import com.mk.jpahibernate.database.CourseSpringDataJpaRepository;
import com.mk.jpahibernate.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JpaHibernateCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJdbRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS", "in28minute"));
        repository.save(new Course(2, "Learn Azure", "in28minute"));
        repository.save(new Course(3, "Learn Devops", "in28minute"));

        System.out.println(repository.findById(2l));

        repository.deleteById(2l);

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("in28minute"));
    }
}
