package com.rajesh.hibernateHandsOn.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rajesh.hibernateHandsOn.demo.entity.Course;
import com.rajesh.hibernateHandsOn.demo.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.ToString;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Repository
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	public Course findById(long id) {
		
		return em.find(Course.class, id);
	}

	@Transactional
	public void deleteById(long id) {
		
		  Course course = em.find(Course.class, id); // Find the entity by its ID
		  
		  logger.info("------------Course is getting deleted inside repository class-------: {}",course);
	        if (course != null) {
	            em.remove(course); // Remove the entity
	        }
	}

	@Transactional
	public Course save(Course course)
	{
		if(course.getId()==null)
			em.persist(course);
		else 
			em.merge(course);
		
		
		return course;
		
	}
	@Transactional
	public Review saveReview(Review review)
	{
		if(review.getReview_Id()==null)
			em.persist(review);
		else 
			em.merge(review);
		
		
		return review;
		
	}
	
	public List<Review> getReviews(Long courseId)
	{
		Course course= findById(courseId);
		logger.info("*************Review for a course**************************", course.getReviews());
		
		
		return course.getReviews();
		
	}
	
	
	public void select_JPQ()
	{ 
		// simple query without type
		Query query=em.createQuery("select c from Course c");
		List resultList =query.getResultList();
		logger.info("-----------------&8&&(&(&(&(&(--------------------");
		logger.info("select c from Course c -> {}", resultList);
		
		
	}
	
	public void selectTQ_JPQ()
	{ 
		// simple query without type
		TypedQuery<Course> query=em.createQuery("select c from Course c",Course.class);
		List<Course> resultList =query.getResultList();
		logger.info("-----------------&8&&(&(&(&(&(--------------------");
		logger.info("select c from Course c USING TYPEQUERY-> {}", resultList);
		
		
	}
}