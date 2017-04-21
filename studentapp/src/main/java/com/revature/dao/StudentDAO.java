package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.model.Student;

@Repository
public class StudentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Student login(String emailId, String password) {
		String sql = "select id,name,email_id from students where email_id = ? and password=?";
		Object[] params = new Object[] { emailId, password };
		Student student = jdbcTemplate.queryForObject(sql, params, (rs, rowno) -> {
			Student stu = new Student();
			stu.setId(rs.getInt("id"));
			stu.setName(rs.getString("name"));
			stu.setEmailId(rs.getString("email_id"));
			return stu;
		});
		return student;
	}

	public List<Student> findAll() {
		String sql = "select id,name,email_id,password,college_name from students";
		List<Student> students = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setEmailId(rs.getString("email_id"));
			student.setCollegeName(rs.getString("college_name"));
			student.setPassword(rs.getString("password"));
			return student;
		});
		return students;
	}

	public Student findById(Integer id) {
		String sql = "select id,name,email_id,password,college_name from students where id=?";
		Object[] params = { id };
		Student students = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setEmailId(rs.getString("email_id"));
			student.setCollegeName(rs.getString("college_name"));
			student.setPassword(rs.getString("password"));
			return student;
		});
		return students;
	}
}
