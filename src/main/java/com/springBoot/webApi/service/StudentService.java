package com.springBoot.webApi.service;

import com.springBoot.webApi.modal.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();
}
