package com.revature.model;

import java.time.LocalDate;

public class StudentSkill {
private Integer id;
private String scale;
private Student student;
private Skill skill;
private LocalDate createdDate;
private LocalDate modifiedDate;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getScale() {
	return scale;
}
public void setScale(String scale) {
	this.scale = scale;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Skill getSkill() {
	return skill;
}
public void setSkill(Skill skill) {
	this.skill = skill;
}
public LocalDate getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}
public LocalDate getModifiedDate() {
	return modifiedDate;
}
public void setModifiedDate(LocalDate modifiedDate) {
	this.modifiedDate = modifiedDate;
}
@Override
public String toString() {
	return "StudentSkill [id=" + id + ", scale=" + scale + ", student=" + student + ", skill=" + skill
			+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
}

}
