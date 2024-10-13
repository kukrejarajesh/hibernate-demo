package com.rajesh.hibernateHandsOn.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.rajesh.hibernateHandsOn.demo.DemoApplication;
import com.rajesh.hibernateHandsOn.demo.entity.Course;


@SpringBootTest(classes=DemoApplication.class)
class CourseRepositoryTests {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@Test
	void findbyIdTestCase() {
		logger.info("******************insideCourse Repository find by id test****************8");
		Course course=repository.findById(10001L);
		//assertEquals("Hibernate course", course.getName());
		assertEquals("Hibernate course", course.getName());
	}
	
	@Test
	@DirtiesContext
	void deletebyIdTestCase() {
		logger.info("***************8insideCourse Repository delete**************************88");
		repository.deleteById(20001L);
		//assertEquals("Hibernate course", course.getName());
		assertNull(repository.findById(20001L));
	}

}
