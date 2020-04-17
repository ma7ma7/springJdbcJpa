package com.webngs.jdbcdemo.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.webngs.jdbcdemo.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findByID(int id) {
		return jdbcTemplate.queryForObject
				("select * from person where id=?", new Object[] {id}, 
						new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public int insertOne(Person person) {
		return jdbcTemplate
				.update("insert into person (id, name, location, date_birth) values(?, ?, ? ,?)"
						, new Object[] {
								person.getId(), person.getName(), person.getLocation(),
								new Timestamp(person.getDate_birth().getTime())
						});
	}

}
