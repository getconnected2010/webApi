package com.springBoot.webApi.controller;

import com.springBoot.webApi.modal.Teacher;
import com.springBoot.webApi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public Teacher add(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("/get/all")
    public List<Teacher> getAll(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Teacher> getOneTeacher(@PathVariable String name){
        Teacher teacher = teacherService.getOneTeacher(name);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

    @PutMapping("/update/{name}")
    public String updateTeacher(@RequestBody Teacher teacher, @PathVariable String name){
        int id = teacherService.update(teacher, name);
        return "record updated at id :"+id;
    }
}
