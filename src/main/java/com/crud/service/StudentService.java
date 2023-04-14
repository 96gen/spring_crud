package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.domain.Student;
import com.crud.repository.StudentRepository;

@Service //管理Model和Controller之間的Bean
public class StudentService {
	@Autowired //讓Controller能夠進行Service部分的功能
	private StudentRepository repo;
	
	//列出全部學生的資訊
	public List<Student> listall(){
		return repo.findAll();
	}
	
	//儲存修改後的學生資訊
	public void save(Student std) {
		repo.save(std);
	}
	
	//根據ID讀取指定的學生資訊
	public Student get(long id) {
		return repo.findById(id).get();
	}
	
	//根據ID刪除指定的學生資訊
	public void delete(long id) {
		repo.deleteById(id);
	}
}
