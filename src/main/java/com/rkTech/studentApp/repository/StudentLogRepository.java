package com.rkTech.studentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rkTech.studentApp.model.StudentLog;

public interface StudentLogRepository extends JpaRepository<StudentLog, Long> {
}