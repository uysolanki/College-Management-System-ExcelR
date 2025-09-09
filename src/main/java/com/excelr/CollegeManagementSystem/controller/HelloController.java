package com.excelr.CollegeManagementSystem.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	@PostMapping("/saveStudentUsingRequestParam")
	public String saveStudentUsingRequestParam(
			@RequestParam("a") int rno,
			@RequestParam("b") String sname,
			@RequestParam("c") double per			
			)
	{
		Student s1=new Student(rno,sname,per);
		studentService.saveStudent(s1);
		return "Record Saved Successfully";
	}
	
	@PostMapping("/saveStudentByPathVariable/{a}/{b}/{c}")
	public String saveStudentByPathVariable(
			@PathVariable("a") int rno,
			@PathVariable("b") String sname,
			@PathVariable("c") double per			
			)
	{
		Student s1=new Student(rno,sname,per);
		studentService.saveStudent(s1);
		return "Record Saved Successfully";
	}
	
	@PostMapping("/saveStudentByRequestBody")
	public String saveStudentByRequestBody(
			@RequestBody Student s1		
			)
	{
		studentService.saveStudent(s1);
		return "Record Saved Successfully";
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	
	}
	
	@GetMapping("/getStudentByRno/{a}")
	public Student getStudentByRno(@PathVariable("a") int rno)
	{
		return studentService.getStudentByRno(rno);
	
	}
	
	@PutMapping("/updateStudent/{a}")
	public String getStudentByRno(@PathVariable("a") int rno, @RequestBody Student newValues)
	{
		studentService.updateStudent(rno,newValues);
		return "Record Updated";
	
	}
	
	@DeleteMapping("/deleteStudent/{a}")
	public String deleteStudent(@PathVariable("a") int rno)
	{
		studentService.deleteStudent(rno);
		return "Record Deleted";
	
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			    "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}


}
