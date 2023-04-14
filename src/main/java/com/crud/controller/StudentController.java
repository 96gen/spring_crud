package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crud.domain.Student;
import com.crud.service.StudentService;

//因為有用到templates，選擇Controller，而不是RestController
@Controller
public class StudentController {
	//讓Controller能使用Service的功能
	@Autowired
	private StudentService service;
	
	@GetMapping("/")// GetMapping等同RequestMapping(method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		//取得全部學生資訊
		List<Student> liststudent = service.listall();
		//從Controller把全部學生資訊傳給View
		model.addAttribute("liststudent", liststudent);
		//顯示templates/index.html
		return "index";
	}
	
	@GetMapping("/new")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		//顯示templates/new.html
		return "new";
	}
	
	//接收form傳來的資訊並儲存
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("student") Student std) {
		service.save(std);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	//在RequestMapping中有傳入id，使用PathVariable接收傳入的參數
	public ModelAndView edit(@PathVariable(name = "id") int id) {
		//使用ModelAndView把來自資料庫的數據傳給View
		ModelAndView mav = new ModelAndView("new");
		Student std = service.get(id);
		mav.addObject("student", std);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
