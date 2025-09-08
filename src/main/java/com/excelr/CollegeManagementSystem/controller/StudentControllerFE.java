package com.excelr.CollegeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.CollegeManagementSystem.model.Student;
import com.excelr.CollegeManagementSystem.service.StudentService;

@Controller
public class StudentControllerFE {
	
	@Autowired
	StudentService studentService;   //ctrl shift o
	
	@GetMapping("/studentRegistrationForm")
	public String studentRegistrationForm(Model model)
	{
		Student student=new Student();
		model.addAttribute("student",student);
		return "student-registration-form";
	}
	
	@PostMapping("/readStudentDetailsFromUI")
	public String readStudentDetailsFromUI(@ModelAttribute Student s1)
	{
		studentService.saveStudent(s1);
		return "confirm";
	}
	
	@RequestMapping("/showAllStudents")
	public String showAllStudents(Model model)
	{
		List<Student> students=studentService.getAllStudents();
		model.addAttribute("students",students);
		return "allstudents";
	}
	
	@RequestMapping("/deleteStudentFE/{rno}")
	public String deleteStudentFE(@PathVariable int rno)
	{
		studentService.deleteStudent(rno);
		return "redirect:/showAllStudents";
	}
	
}
