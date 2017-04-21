package com.revature.daotest;

import java.util.List;

import com.revature.dao.StudentSkillDAO;
import com.revature.model.StudentSkill;

public class DAOTest {

	public static void main(String[] args) {
      StudentSkillDAO skill=new StudentSkillDAO();
      List<StudentSkill> list=skill.findById(1);
      System.out.println(list);
	}

}
