package com.crud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //宣告此類是實體，對應一個數據表
public class Student {
	@Id //Id是primary key
	//因為在mysql把id設定為auto increment，因此選擇IDENTITY
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String studentname;
	private String course;
	private int fee;
	
	public Student() {}
	public Student(long id, String studentname, String course, int fee) {
		this.id = id;
		this.studentname = studentname;
		this.course = course;
		this.fee = fee;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getStudentname() {
		return studentname;
	}
	
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public int getFee() {
		return fee;
	}
	
	public void setFee(int fee) {
		this.fee = fee;
	}
}
