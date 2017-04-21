package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.StudentSkillDAO;
import com.revature.model.StudentSkill;

@Service
public class StudentSkillService {

	@Autowired
	private StudentSkillDAO studentSkillDAO;

	public void update(StudentSkill studentSkill) {
		studentSkillDAO.update(studentSkill);
	}

	public List<StudentSkill> findById(Integer id) {
		return studentSkillDAO.findById(id);
	}
}
