package com.m19y.belajar.spring.boot.repository;

import com.m19y.belajar.spring.boot.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
