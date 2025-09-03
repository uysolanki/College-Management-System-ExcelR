package com.excelr.CollegeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.CollegeManagementSystem.model.Student;
import com.excelr.CollegeManagementSystem.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public void saveStudent(Student s1) {
		studentRepository.save(s1);
		
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}  

}
