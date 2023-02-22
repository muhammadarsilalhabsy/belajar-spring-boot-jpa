package com.m19y.belajar.spring.boot.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_student",

        // add constraint
        uniqueConstraints = {
                @UniqueConstraint(name = "email_id_uniequ", columnNames = "email_address")
        }
)
public class Student {

  @Id
  @SequenceGenerator(
          name = "student_sequence",
          sequenceName = "student_sequence",
          allocationSize = 1
  )
  @GeneratedValue(generator = "student_sequence",strategy = GenerationType.SEQUENCE)
  private Long studentId;
  private String firstName;
  private String lastName;

//  not null
  @Column(name = "email_address", nullable = false)
  private String emailId;

//  embeddable
  @Embedded
  private Guardian guardian;


}
