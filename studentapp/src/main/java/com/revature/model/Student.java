package com.revature.model;

public class Student {
private Integer id;
private String name;
private String collegeName;
private String emailId;
private String password;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", collegeName=" + collegeName + ", emailId=" + emailId
			+ ", password=" + password + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCollegeName() {
	return collegeName;
}
public void setCollegeName(String collegeName) {
	this.collegeName = collegeName;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
