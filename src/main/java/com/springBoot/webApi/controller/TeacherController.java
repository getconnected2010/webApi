package com.springBoot.webApi.controller;

import com.springBoot.webApi.modal.Teacher;
import com.springBoot.webApi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public Teacher add(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }
}
