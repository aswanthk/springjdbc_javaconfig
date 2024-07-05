package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
	public int insert(Student student);
	public int modify(Student student);
	public int delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getStudents();
}
