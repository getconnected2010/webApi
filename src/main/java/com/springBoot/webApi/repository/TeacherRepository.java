package com.springBoot.webApi.repository;

import com.springBoot.webApi.modal.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByName(String name);

}
