package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.SkillDAO;
import com.revature.model.Skill;

@Service
public class SkillService {

	@Autowired
	private SkillDAO skillDAO;

	public Skill findById(Integer id) {
		return skillDAO.findById(id);
	}

	public List<Skill> findAll() {
		return skillDAO.findAll();
	}

	public void save(Skill skill) {
		skillDAO.add(skill);
	}
}
