package com.m19y.belajar.spring.boot.repository;

import com.m19y.belajar.spring.boot.entity.Guardian;
import com.m19y.belajar.spring.boot.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentRepositoryTest(StudentRepository studentRepository){
    this.studentRepository = studentRepository;
  }


  @Test
  void testSaveStudent() {

    Student firstStudent = Student.builder()
            .firstName("otong")
            .lastName("bin udin")
            .emailId("otong@gmail.com")
//            .guardianEmail("surotong@gmail.com")
//            .guardianName("surotong")
//            .guardianMobil("08533642199")
            .build();

    studentRepository.save(firstStudent);
  }

  @Test
  void testAddStudentWithGuardianEmbedded() {
    Guardian guardian = Guardian.builder()
            .name("mary")
            .email("mary@gmail.com")
            .mobile("081234567891")
            .build();
    Student student = Student.builder()
            .firstName("jomlah")
            .lastName("itudi")
            .emailId("jomlahtamvan@gmail.com")
            .guardian(guardian)
            .build();

    studentRepository.save(student);
  }

  @Test
  void testMethodCreation() {
    List<Student> students = studentRepository.findByFirstName("jomlah");
    System.out.println(students);
  }

  @Test
  void testMethodCreationContain() {
    List<Student> students = studentRepository.findByFirstNameContaining("o");
    System.out.println(students);
  }

  @Test
  void testMethodFindByGuardianName() {
    List<Student> students = studentRepository.findByGuardianName("mary");
    System.out.println(students);
  }

  @Test
  void testFindAllStudent() {

    List<Student> students = studentRepository.findAll();

    System.out.println("Students => " + students);
  }


//  Query JPQL

  @Test
  void testFindByEmailIdUsingQueryJPQL() {
    Student student = studentRepository.findByEmailAddress("arsiltamvan@gmail.com");
    System.out.println(student); // return id 2
  }

  @Test
  void testFindFirstNameByEmailIdUsingQueryJPQL() {
    String student = studentRepository.findFirstNameByEmailAddress("arsiltamvan@gmail.com");
    System.out.println(student); // return a string
  }

  //  Native query
  @Test
  void testFindByEmailAddressUsingNativeQuery() {
    Student student = studentRepository.findByEmailAddressNative("arsiltamvan@gmail.com");
    System.out.println(student); // return id 2
  }

  //  Native query with param
  @Test
  void testFindByEmailAddressUsingNativeQueryWithParam() {
    Student student = studentRepository.findByEmailAddressNativeWithParam("arsiltamvan@gmail.com");
    System.out.println(student); // return id 2
  }

  @Test
  void testUpdateFirstNameByeEmailID() {

    studentRepository.updateFirstNameByEmailId("arsiltamvan@gmail.com", "terserah saya dong");
  }
}