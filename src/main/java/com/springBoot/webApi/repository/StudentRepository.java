package com.springBoot.webApi.repository;

import com.springBoot.webApi.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> { //Integer points to primary key int id;
    public Student findByName(String name);

    @Query(value="select * from student where name=?1 and age=?2", nativeQuery = true)
    public List<Student> findByNameAge(String name, int age);
}
