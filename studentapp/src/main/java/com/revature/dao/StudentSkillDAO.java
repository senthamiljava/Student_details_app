package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.model.Skill;
import com.revature.model.Student;
import com.revature.model.StudentSkill;

@Repository
public class StudentSkillDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	SkillDAO skillDAO;

	public void update(StudentSkill studentSkill) {

		String sql = "update student_skills set scale=? where student_id= ? and skill_id=?";
		Object[] params = new Object[] { studentSkill.getScale(), studentSkill.getModifiedDate(),
				studentSkill.getStudent().getId(), studentSkill.getSkill().getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated:" + rows);
	}

	public List<StudentSkill> findById(Integer id) {
		String sql = "SELECT student.id,student.name,skill.id,skill.name,stu_skill.scale FROM student_skills stu_skill,students student,skills skill WHERE student.id=? AND stu_skill.student_id=? GROUP BY skill.name order by 3";
		Object[] params = { id, id };
		// System.out.println("skill dao id"+id);
		List<StudentSkill> userList = jdbcTemplate.query(sql, params,(rs, rowno) -> {
			StudentSkill user = new StudentSkill();
			Student student = new Student();
			Integer studentId = rs.getInt("student.id");
			student = studentDAO.findById(studentId);
			
			System.out.println("skill dao student" + student);
			
			Skill skill = new Skill();
			Integer skillId = rs.getInt("skill.id");
			skill = skillDAO.findById(skillId);
			
			System.out.println("skill dao skill" + skill);
			
			user.setStudent(student);
			user.setSkill(skill);
			user.setScale(rs.getString("scale"));
			return user;
		});
		return userList;
	}

}
