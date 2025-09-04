package com.excelr.CollegeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.CollegeManagementSystem.model.Teacher;
import com.excelr.CollegeManagementSystem.service.TeacherService;

@RestController //return raw json data , which we will get on POSTMAN
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	//create - postmatting
	
	@PostMapping("/saveTeacher")
	public Teacher saveTeacher(@RequestBody Teacher teacher)
	{
		return teacherService.saveTeacher(teacher);
	}
	
	
	@PostMapping("/saveMultipleTeachers")
	public List<Teacher> saveTeacher(@RequestBody List<Teacher> teachers)
	{
		return teacherService.saveMultipleTeachers(teachers);
	}
	
	
	//read  - getmapping
	@GetMapping("/getAllTeachers")
	public List<Teacher> getAllTeachers()
	{
		return teacherService.getAllTeachers();
	}
	
	
	@GetMapping("/getTeacher/{tno}")
	public Teacher getTeacher(@PathVariable("tno") int tno)
	{
		return teacherService.getTeacher(tno);
	}
	
	//update - putmapping
	
	@PutMapping("/updateTeacher/{a}")
	public String updateTeacher(@PathVariable("a") int tno,@RequestBody Teacher newValues)
	{
		teacherService.updateTeacher(tno,newValues);
		return "Record Updated Successfully";
	}
	
	
	//delete  - deletemapping
	@DeleteMapping("/deleteTeacher/{tno}")
	public String deleteTeacher(@PathVariable("tno") int tno)
	{
		teacherService.deleteTeacher(tno);
		return "Record Deleted Successfully";
	}
}
