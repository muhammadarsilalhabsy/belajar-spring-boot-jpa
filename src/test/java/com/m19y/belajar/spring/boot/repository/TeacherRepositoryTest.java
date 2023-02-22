package com.m19y.belajar.spring.boot.repository;

import com.m19y.belajar.spring.boot.entity.Course;
import com.m19y.belajar.spring.boot.entity.Teacher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
  
  @Autowired
  private TeacherRepository repository;

  @Test
  @Disabled
  void saveTeacher() {

    Course course1 = Course.builder()
            .title("matematika")
            .credit(7)
            .build();

    Course course2 = Course.builder()
            .title("ipa")
            .credit(8)
            .build();

    Course course3 = Course.builder()
            .title("sbk")
            .credit(7)
            .build();

    Teacher teacher = Teacher.builder()
            .firstName("ajib")
            .lastName("darmawan")
//            .courses(List.of(course1, course2, course3))
            .build();

    repository.save(teacher);

  }
}