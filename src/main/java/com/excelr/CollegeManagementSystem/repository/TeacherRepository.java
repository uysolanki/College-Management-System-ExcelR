package com.excelr.CollegeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.CollegeManagementSystem.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>
{

}
