package com.cg.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.lms.entity.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

}
