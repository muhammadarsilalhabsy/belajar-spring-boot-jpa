package com.m19y.belajar.spring.boot.repository;

import com.m19y.belajar.spring.boot.entity.Course;
import com.m19y.belajar.spring.boot.entity.Student;
import com.m19y.belajar.spring.boot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
  
  @Autowired
  private CourseRepository courseRepository;

  @Test
  void testFindAllCourses() {
    List<Course> courses = courseRepository.findAll();
    System.out.println(courses);
  }

  @Test
  void testAddCourseWithTeacher() {
    Teacher teacher = Teacher.builder()
            .firstName("arsil")
            .lastName("alhabsy")
            .build();

    Course basisdata = Course.builder()
            .title("basisdata")
            .credit(8)
            .teacher(teacher)
            .build();

    courseRepository.save(basisdata);

  }

  @Test
  void findAllUsingPagination() {
    Pageable firstPageWithThreeRecord = PageRequest.of(0,3);
    Pageable secondPageWithTwoRecord = PageRequest.of(1,2);

    List<Course> courses = courseRepository.findAll(secondPageWithTwoRecord).getContent();

    long totalElements = courseRepository.findAll(secondPageWithTwoRecord).getTotalElements();
    int totalPages = courseRepository.findAll(secondPageWithTwoRecord).getTotalPages();



    System.out.println("total elements : " + totalElements);
    System.out.println("total pages : " + totalPages);
    System.out.println(courses);
  }

  @Test
  void testFindAllCoursesWithTeacher() {

    // select * from course order by title asc
    Pageable sortByTitleAsc = PageRequest.of(0,2, Sort.by("title"));

    // select * from course order by credit desc
    Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());

    // select * from course order by title asc, credit desc
    Pageable sortByTitleAscAndCreditDesc = PageRequest.of(0,2, Sort.by("title").and(Sort.by("credit").descending()));

//    List<Course> courses = courseRepository.findAll(sortByTitleAsc).getContent();
//    List<Course> courses = courseRepository.findAll(sortByCreditDesc).getContent();
    List<Course> courses = courseRepository.findAll(sortByTitleAscAndCreditDesc).getContent();

    System.out.println(courses);

  }

  @Test
  void findByTitleContainingTest() {

    Pageable sortByTitleContaining = PageRequest.of(0,10);

    List<Course> courses = courseRepository.findByTitleContaining("at", sortByTitleContaining).getContent();

    System.out.println(courses);
  }

  @Test
  void saveCourseStudentAndTeacherOnManyToManyTest() {
    Teacher teacher = Teacher.builder()
           .firstName("jamal")
           .lastName("bin udin")
           .build();

    Course ai = Course.builder()
           .title("AI")
           .credit(8)
           .teacher(teacher)
           .build();

    Student student = Student.builder()
            .firstName("jafar")
            .lastName("habib")
            .emailId("jafarhabib@gmail.com")
            .build();

    ai.addStudent(student);

    courseRepository.save(ai);



  }
}

