package com.rajesh.hibernateHandsOn.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rajesh.hibernateHandsOn.demo.entity.Course;
import com.rajesh.hibernateHandsOn.demo.entity.Passport;
import com.rajesh.hibernateHandsOn.demo.entity.Review;
import com.rajesh.hibernateHandsOn.demo.entity.Student;
import com.rajesh.hibernateHandsOn.demo.repository.CourseRepository;
import com.rajesh.hibernateHandsOn.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
@Transactional
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private CourseRepository repository;
	@Autowired
	private StudentRepository studentRepository;
	
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Course course= repository.findById(10001L);
//		logger.info("Course: {}",course);
//		logger.info("removing course");
//		Course course1=new Course();
//		course1.setId(30001L);
//		course1.setName("Microservices Design");
//		repository.save(course1);
//		repository.select_JPQ();
//		repository.selectTQ_JPQ();
		
		//repository.deleteById(10001L);
		
//		Passport ppt=new Passport();
//		ppt.setPassportNumber("newpassport");
//		
//		Student student=new Student();
//		student.setName("Student 102 ");
//		student.setPassport(ppt);
//		studentRepository.save(student);
//		
//		
//		student= studentRepository.findById(102);
//		logger.info("student with ide 102 : {}", student);
//		logger.info("student passport  with ide 102 : {}", student.getPassport());
		
		
		Course course= repository.findById(10001L);
		Review review=new Review();
		review.setDescription("It is an avergae course");
		review.setCourse(course);
		
				
		repository.saveReview(review);
		
		
		
	}

}
