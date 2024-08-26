package com.sm.DAO;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sm.api.Student;
import com.sm.rowMapper.StudentRowMapper;

@Repository
public class StudentDAOImpls implements StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudent() {
		
		
		String sql="SELECT * FROM students";
		
		List<Student> theListOfStudents = jdbcTemplate.query(sql, new StudentRowMapper());
		
		return theListOfStudents;
	}
	@Override
	public void saveStudent(Student student) {
		
		Object [] sqlParameters= {student.getName(),student.getMobile(),student.getCountry()};
		
		String sql="insert into students(name,mobile,country) values (?,?,?)";
		
		jdbcTemplate.update(sql,sqlParameters);
		System.out.println("1 row affected");
		System.out.println(student);
	}
	
	@Override
	public Student getStudent(int id) {
		String sql="select * from students where id=?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(),id)	;
		
		
		
		return student;
	}
	@Override
	public void update(Student student) {
		String sql="update  students SET name=? , mobile=? , country=?	 where id=?";
		jdbcTemplate.update(sql,student.getName(),student.getMobile(),student.getCountry(),student.getId());
		System.out.println("1 record updated......");
	}
	@Override
	public void deleteStudent(int id) {
		
		String sql="delete from  students where id=? ";
		jdbcTemplate.update(sql,id);
		System.out.println("1 record deleted......");

				
	}

}
