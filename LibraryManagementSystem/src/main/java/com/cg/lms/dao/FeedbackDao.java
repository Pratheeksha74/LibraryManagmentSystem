package com.cg.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.lms.entity.Feedback;
import com.cg.lms.entity.Users;

public interface FeedbackDao extends JpaRepository<Feedback, Integer>{
	public Feedback findByUser(Users user);
}
