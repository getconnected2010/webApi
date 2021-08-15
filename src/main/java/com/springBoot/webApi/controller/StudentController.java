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

    @GetMapping("/filter/{name}/{age}")
    public List<Student> filterNameAge(@PathVariable String name, @PathVariable int age){
        return studentService.filterNameAge(name, age);
    }

    @PutMapping("/update/{name}")
    public String update(@PathVariable String name, @RequestBody Student student){
        try{
            studentService.getStudent(name);
            studentService.updateStudent(name, student);
            return "record updated with id: "+ name;
        }catch (NoSuchElementException e){
            return "no such record";
        }
    }

    @DeleteMapping("/delid/{id}")
    public String delete(@PathVariable int id){
        studentService.delStudent(id);
        return "student deleted by id";
    }

    @DeleteMapping("/delname/{name}")
    public String delete(@PathVariable String name){
        int deleted = studentService.delStudent(name);
        return "Student deleted by name. Count: "+ deleted;
    }
}

