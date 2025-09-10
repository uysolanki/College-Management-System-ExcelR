package com.excelr.CollegeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.CollegeManagementSystem.model.Teacher;
import com.excelr.CollegeManagementSystem.service.TeacherService;

@Controller //return a webpage, which we will see on web browser
public class TeacherControllerFrontEnd {
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/test1")
	public String test(Model model)
	{
		String name="Rohit";
		
		Teacher teacher=new Teacher(10,"Sachin",45,900);
		model.addAttribute("teacher1",teacher);
		return "test";
	}
	
	
	@GetMapping("/test2")
	public String test2(ModelMap modelmap)
	{
		String name="Rohit";
		
		Teacher teacher=new Teacher(10,"Sachin",45,900);
		modelmap.addAttribute("player",name);
		modelmap.addAttribute("teacher1",teacher);
		return "test";
	}
	
	
	@GetMapping("/teacherRegistrationForm")
	public String teacherRegistrationForm(Model model)
	{
		Teacher teacher=new Teacher();
		model.addAttribute("teacher",teacher);
		return "teacher-registration-form";
	}
	
	
	@GetMapping("/readTeacherDetailsFromUI")
	public String readTeacherDetailsFromUI(@ModelAttribute Teacher teacher)
	{
		Teacher teacher1=teacherService.saveTeacher(teacher);
//		System.out.println(teacher);
		return "redirect:/";
	}
	
	
	@RequestMapping("/")
	public String showAllTeachers(Model model)
	{
		List<Teacher> teachers=teacherService.getAllTeachers();
		model.addAttribute("teachers",teachers);
//		System.out.println(teacher);
		return "allteachers";
	}
	
	@RequestMapping("/deleteTeacherFE/{tno}")
	public String deleteTeacher(@PathVariable("tno") int tno)
	{
		teacherService.deleteTeacher(tno);
		return "redirect:/";
	}
	
	@RequestMapping("/updateTeacherForm/{tno}")
	public String updateTeacher(@PathVariable("tno") int tno, Model model)
	{
		Teacher teacher=teacherService.getTeacher(tno);
		model.addAttribute("teacher",teacher);
		return "update-teacher-form";
	}
	
	@PostMapping("/updateTeacher/{tno}")
	public String updateTeacher(@PathVariable("tno") int tno, @ModelAttribute Teacher newValues)
	{
		teacherService.updateTeacher(tno,newValues);
		return "redirect:/";
	}

}
