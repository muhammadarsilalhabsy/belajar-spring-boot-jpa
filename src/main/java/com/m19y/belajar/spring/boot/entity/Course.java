package com.m19y.belajar.spring.boot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

  @Id
  @SequenceGenerator(
          name = "course_sequence",
          sequenceName = "course_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          generator = "course_sequence",
          strategy = GenerationType.SEQUENCE
  )
  private Long courseId;
  private String title;
  private Integer credit;

  @OneToOne(
          mappedBy = "course"
  )
  private CourseMaterial courseMaterial;

  @ManyToOne(
          cascade = CascadeType.ALL
  )
  @JoinColumn(
          name = "teacher_id",
          referencedColumnName = "teacherId"
  )
  private Teacher teacher;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
          name = "course_student_map",
          joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
          inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId")
  )
  private List<Student> students;

  public void addStudent(Student student) {
    if(students == null) students = new ArrayList<>();
    students.add(student);
  }
}
