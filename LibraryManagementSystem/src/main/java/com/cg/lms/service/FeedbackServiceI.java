package com.cg.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.lms.entity.Feedback;

@Service
public interface FeedbackServiceI {
	public Feedback writeFeedback(Feedback feedback);
	public void updateFeedbackbyId(int id, Feedback feedback);  //given int as return type
	public List<Feedback> viewFeedbackList();
	public Feedback viewFeedBackByUser(int userid);
}
