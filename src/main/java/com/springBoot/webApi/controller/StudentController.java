package com.springBoot.webApi.controller;

import com.springBoot.webApi.modal.Student;
import com.springBoot.webApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student saved";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> get(@PathVariable int id){
        try{
            Student student = studentService.getStudent(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getName/{name}")
    public ResponseEntity<Student> getName(@PathVariable String name){
        Student student = studentService.getStudent(name);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Student student){
        try{
            studentService.getStudent(id);
            studentService.updateStudent(id, student);
            return "record updated with id: "+ id;
        }catch (NoSuchElementException e){
            return "no such record";
        }
    
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        studentService.delStudent(id);
        return "student deleted";
    }
}

