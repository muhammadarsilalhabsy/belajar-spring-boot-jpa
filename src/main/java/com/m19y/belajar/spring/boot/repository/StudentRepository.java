package com.m19y.belajar.spring.boot.repository;

import com.m19y.belajar.spring.boot.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

/*
  kita bisa menambahakan method untuk melalkukan query, namun
  apabila querynya mudah, seperti find by firstname, lastname dan sebagainya
  spring memudahkan kita, dengan membuat method yang memilki format yang sudah ditentukan
  tanpa perlu mentimplementasikan logic methodnya
*/

  List<Student> findByFirstName (String param);

  List<Student> findByFirstNameContaining(String o);

  List<Student> findByGuardianName(String name);

//  JPQL
  @Query("select s from Student s where s.emailId = ?1")
  Student findByEmailAddress(String email);

  @Query("select s.firstName from Student s where s.emailId = ?1")
  String findFirstNameByEmailAddress(String email);

  // native query
  @Query(value = "select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
  Student findByEmailAddressNative(String email);

  // using parameter
  @Query(value = "select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
  Student findByEmailAddressNativeWithParam(
          @Param("emailId") String emailId
  );

  // update data
  @Modifying
  @Transactional
  @Query(
          value = "update tbl_student set first_name = ?2 where email_address = ?1 ",
          nativeQuery = true
  )
  void updateFirstNameByEmailId(String emailId, String firstName);
}
