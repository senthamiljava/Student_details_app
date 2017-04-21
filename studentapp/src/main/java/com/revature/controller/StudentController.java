package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.model.Student;
import com.revature.service.StudentService;

@CrossOrigin
@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping
	public List<Student> list() {

		List<Student> list = studentService.findAll();
		return list;

	}

	@GetMapping("/{id}")
	public Student findById(@PathVariable("id") Integer id) {
		return studentService.findById(id);
	}

	@PostMapping("/login")
	public String save(@RequestParam("email") String emailId, @RequestParam("password") String password,ModelMap modelMap,HttpSession session)
			throws Exception {
		System.out.println(emailId + "" + password);
		Student student=studentService.login(emailId, password);
//		Integer id=student.getId();
//		System.out.println(id);
		if(student!=null)
		{
		session.setAttribute("logged_in_user",student);
		}
		else
		{
			modelMap.addAttribute("error_message", "Invalid Email Id/Password");
		}
		return "redirect:/skill/studentskill";
	}

	@GetMapping("/create")
	public String create() {
		System.out.println("login inviked");
		return "login_user";
	}
}
