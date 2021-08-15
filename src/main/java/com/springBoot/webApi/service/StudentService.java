package com.springBoot.webApi.service;

import com.springBoot.webApi.modal.Student;
import com.springBoot.webApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired  //referencing an interface
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) { //implements the interface
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }

    public Student getStudent(int id){
        return studentRepository.findById(id).get();
    }

    public Student getStudent(String name){

        return studentRepository.findByName(name);
    }

    public void updateStudent(String name, Student student){
        Student dbStu = studentRepository.findByName(name);
        student.setId(dbStu.getId());
        saveStudent(student);
    }

    public void delStudent(int id){

        studentRepository.deleteById(id);
    }
    public void delStudent(String name){

    }

    public List<Student> filterNameAge(String name, int age){
        return studentRepository.findByNameAge(name, age);
    }

    //}
}
