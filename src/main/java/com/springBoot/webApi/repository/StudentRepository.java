package com.springBoot.webApi.repository;

import com.springBoot.webApi.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> { //Integer points to primary key int id;
    public Student findByName(String name);
}
