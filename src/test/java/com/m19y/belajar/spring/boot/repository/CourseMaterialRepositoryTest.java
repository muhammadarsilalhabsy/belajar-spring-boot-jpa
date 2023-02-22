package com.m19y.belajar.spring.boot.repository;

import com.m19y.belajar.spring.boot.entity.Course;
import com.m19y.belajar.spring.boot.entity.CourseMaterial;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

  @Autowired
  private CourseMaterialRepository courseMaterialRepository;


  @Test
  void testSaveCourseMaterial() {
    Course course = Course.builder()
            .title("olahraga")
            .credit(8)
            .build();

    CourseMaterial courseMaterial = CourseMaterial.builder()
            .url("www.spongebob.com")
            .course(course)
            .build();

    courseMaterialRepository.save(courseMaterial);
  }

  @Test
  void testFetchAllCourseMaterials() {
    List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
    System.out.println(courseMaterials);
  }
}