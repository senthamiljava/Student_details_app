package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.model.Skill;

@Repository
public class SkillDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Skill> findAll() {
		String sql = "select id,name from skills";
		List<Skill> skills = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Skill skill = new Skill();
			skill.setId(rs.getInt("id"));
			skill.setName(rs.getString("name"));
			return skill;
		});
		return skills;
	}

	public Skill findById(Integer id) {
		String sql = "select id,name from skills where id=?";
		Object[] params = { id };
		Skill skills = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Skill skill = new Skill();
			skill.setId(rs.getInt("id"));
			skill.setName(rs.getString("name"));
			return skill;
		});
		return skills;
	}

	public void add(Skill skill) {
		String sql = "insert into skills(id,name) values(?,?)";
		Object[] params = { skill.getId(), skill.getName() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("number of rows inserted");
	}
}
