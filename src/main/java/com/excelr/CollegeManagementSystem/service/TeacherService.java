package com.excelr.CollegeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.CollegeManagementSystem.model.Teacher;
import com.excelr.CollegeManagementSystem.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
		
	}

	public List<Teacher> saveMultipleTeachers(List<Teacher> teachers) {
	return teacherRepository.saveAll(teachers);
	}

	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	public Teacher getTeacher(int tno) {
		return teacherRepository.findById(tno).get();
	}

	public void updateTeacher(int tno, Teacher newValues) {
		Teacher teacherFromDB=getTeacher(tno);
		teacherFromDB.setAge(newValues.getAge());
		teacherFromDB.setSal(newValues.getSal());
		teacherFromDB.setTname(newValues.getTname());
		
		teacherRepository.save(teacherFromDB);
		
		
	}

	public void deleteTeacher(int tno) {
		teacherRepository.deleteById(tno);
		
	}

}
