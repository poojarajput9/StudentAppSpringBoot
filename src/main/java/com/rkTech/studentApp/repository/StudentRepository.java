package com.rkTech.studentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rkTech.studentApp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}