package com.springBoot.webApi.service;

import com.springBoot.webApi.modal.Teacher;
import com.springBoot.webApi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher getOneTeacher(String name){
        return teacherRepository.findByName(name);
    }

    public int update(Teacher teacher, String name){
        Teacher temp = teacherRepository.findByName(name);
        teacher.setId(temp.getId());
        return saveTeacher(teacher).getId();
    }
}
