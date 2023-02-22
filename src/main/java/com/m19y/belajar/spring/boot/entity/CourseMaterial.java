package com.m19y.belajar.spring.boot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

  @Id
  @SequenceGenerator(
          name = "course_material_sequence",
          sequenceName = "course_material_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          generator = "course_material_sequence",
          strategy = GenerationType.SEQUENCE
  )
  private Long courseMaterialId;
  private String url;


  @OneToOne(
          cascade = CascadeType.ALL,
          fetch = FetchType.LAZY,
          optional = false // by default true
  )
  @JoinColumn(
          name = "course_id",
          referencedColumnName = "courseId"
  )
  private Course course;

}
