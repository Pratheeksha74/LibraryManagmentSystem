package com.cg.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.dao.FeedbackDao;
import com.cg.lms.entity.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackServiceI {
	@Autowired
	FeedbackDao feedDao;

	@Override
	public Feedback writeFeedback(Feedback feedback) {
		return feedDao.save(feedback);
	}
	
	@Override
	public void updateFeedbackbyId(int id, Feedback feedback) {
		if(feedDao.existsById(id)) {
			feedDao.save(feedback);
		}
	}

	@Override
	public List<Feedback> viewFeedbackList() {
		return feedDao.findAll();
	}

	@Override
	public Feedback viewFeedBackByUser(int userid) {
		return feedDao.findById(userid).get();
	}


}
