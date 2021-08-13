package com.springBoot.webApi.service;

import com.springBoot.webApi.modal.Student;
import com.springBoot.webApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService{
    @Autowired  //referencing an interface
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) { //implements the interface
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();

    }
}
