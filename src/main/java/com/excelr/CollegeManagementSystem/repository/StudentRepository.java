package com.excelr.CollegeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.CollegeManagementSystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
