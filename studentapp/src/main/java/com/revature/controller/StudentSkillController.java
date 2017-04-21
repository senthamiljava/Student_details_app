package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.model.Skill;
import com.revature.model.Student;
import com.revature.model.StudentSkill;
import com.revature.service.StudentSkillService;

@CrossOrigin
@Controller
@RequestMapping("/skill")
public class StudentSkillController {
	@Autowired
	StudentSkillService studentSkillService;

	@GetMapping("/studentskill")
	public String findById(HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception {
		Student student = (Student) session.getAttribute("logged_in_user");
		System.out.println(student);
		List<StudentSkill> list = studentSkillService.findById(student.getId());
		modelMap.addAttribute("skill_list", list);
		System.out.println(list);
		return "skill_user";
	}

	@GetMapping("/update")
	@RequestMapping(value = "/skill_id", method = RequestMethod.GET)
	public String update(@RequestParam("scale") String scale,
			@RequestParam(value = "skill_id", required = false) Integer id, ModelMap modelMap, HttpSession session) {
		System.out.println("methodddd invokkkk");
		Student student = (Student) session.getAttribute("logged_in_user");
		Skill skill = new Skill();
		skill.setId(id);
		StudentSkill studentSkill = new StudentSkill();
		studentSkill.setScale(scale);
		studentSkill.setStudent(student);
		studentSkill.setSkill(skill);
		studentSkillService.update(studentSkill);
		System.out.println("successfully updated");
		return "index";
	}

}
