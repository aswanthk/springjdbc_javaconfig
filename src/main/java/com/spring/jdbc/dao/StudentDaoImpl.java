package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		String query="insert into student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	@Override
	public int modify(Student student) {
		String query="update student set name=?, city=? where id=?";
		int result=this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	@Override
	public int delete(int studentId) {
		String query="delete from student where id=?";
		int result=this.jdbcTemplate.update(query, studentId);
		return result;
	}

	@Override
	public Student getStudent(int studentId) {
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student result = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return result;
	}

	@Override
	public List<Student> getStudents() {
		String query="select * from student";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		List<Student> results = this.jdbcTemplate.query(query, rowMapper);
		return results;
	}

}
