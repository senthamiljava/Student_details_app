package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.StudentDAO;
import com.revature.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public Student login(String emailId, String password) {
		return studentDAO.login(emailId, password);
	}

	public Student findById(Integer id) {
		return studentDAO.findById(id);
	}

	public List<Student> findAll() {
		return studentDAO.findAll();
	}
}
