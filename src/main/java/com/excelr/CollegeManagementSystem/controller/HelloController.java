package com.excelr.CollegeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.CollegeManagementSystem.model.Student;
import com.excelr.CollegeManagementSystem.service.StudentService;

@RestController
public class HelloController {
	
	@Autowired
	StudentService studentService;   //ctrl shift o
	
	@GetMapping("/hello")    
	public String hello()
	{
		return "Welcome to Project Session";
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "Springboot";
	}
	
	@GetMapping("/saveStudent")
	public String saveStudent()
	{
		Student s1=new Student(18,"Virat",78.5);
		studentService.saveStudent(s1);
		return "Record Saved Successfully";
	}

}
