package com.excelr.CollegeManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Teacher {
	
	@Id
	int tno;
	String tname;
	int age;
	int sal;
	public Teacher() {}
	public Teacher(int tno, String tname, int age, int sal) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.age = age;
		this.sal = sal;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", age=" + age + ", sal=" + sal + "]";
	}
	
	
	
}
