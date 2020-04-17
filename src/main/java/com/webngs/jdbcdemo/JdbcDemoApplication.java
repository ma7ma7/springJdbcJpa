package com.webngs.jdbcdemo;

import org.slf4j.LoggerFactory;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.webngs.jdbcdemo.entity.Person;
import com.webngs.jdbcdemo.jdbc.PersonJdbcDao;

@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {

	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All data -> {}", dao.findAll());
		logger.info("Data -> {}", dao.findByID(1001));
		logger.info("ٌRow Modified -> {}", dao.deleteById(1001));
		logger.info("ٌAdd -> {}", dao.insertOne(new Person(1005, "test", "maroc", new Date())));
	}

}
