package com.m19y.belajar.spring.boot.repository;

import com.m19y.belajar.spring.boot.entity.Course;
import com.m19y.belajar.spring.boot.entity.CourseMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {


}
