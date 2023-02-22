package com.m19y.belajar.spring.boot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

  @Id
  @SequenceGenerator(
          name = "teacher_sequence",
          allocationSize = 1,
          sequenceName = "teacher_sequence"
  )
  @GeneratedValue(
          generator = "teacher_sequence",
          strategy = GenerationType.SEQUENCE
  )
  private Long teacherId;
  private String firstName;
  private String lastName;


}
