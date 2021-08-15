package com.springBoot.webApi.service;

import com.springBoot.webApi.modal.Teacher;
import com.springBoot.webApi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
