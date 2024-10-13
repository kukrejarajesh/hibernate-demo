package com.rajesh.hibernateHandsOn.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rajesh.hibernateHandsOn.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.ToString;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Repository
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	public Student findById(long id) {
		
		return em.find(Student.class, id);
	}

	@Transactional
	public void deleteById(long id) {
		
		  Student student = em.find(Student.class, id); // Find the entity by its ID
		  
		  logger.info("------------Student is getting deleted inside repository class-------: {}",student);
	        if (student != null) {
	            em.remove(student); // Remove the entity
	        }
	}

	@Transactional
	public Student save(Student student)
	{
		if(student.getId()==null)
			em.persist(student);
		else 
			em.merge(student);
		
		
		return student;
		
	}
	
	public void select_JPQ()
	{ 
		// simple query without type
		Query query=em.createQuery("select c from Student c");
		List resultList =query.getResultList();
		logger.info("-----------------&8&&(&(&(&(&(--------------------");
		logger.info("select c from Student c -> {}", resultList);
		
		
	}
	
	public void selectTQ_JPQ()
	{ 
		// simple query without type
		TypedQuery<Student> query=em.createQuery("select c from Student c",Student.class);
		List<Student> resultList =query.getResultList();
		logger.info("-----------------&8&&(&(&(&(&(--------------------");
		logger.info("select c from Student c USING TYPEQUERY-> {}", resultList);
		
		
	}
}