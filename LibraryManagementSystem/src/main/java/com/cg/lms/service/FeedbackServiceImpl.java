package com.cg.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.dao.FeedbackDao;
import com.cg.lms.dao.UsersDao;
import com.cg.lms.entity.Feedback;
import com.cg.lms.entity.Users;
import com.cg.lms.exception.FeedbackNotFoundException;
import com.cg.lms.exception.UserNotFoundException;

@Service
public class FeedbackServiceImpl implements FeedbackServiceI {
	@Autowired
	FeedbackDao feedDao;
	
	@Autowired
	UsersDao userDao;
	
	
	@Override
	public Feedback writeFeedback(int userid,Feedback feedback) {
		if(userDao.existsById(userid)) {
			Users users = userDao.findById(userid).get();
			feedback.setUser(users);
			return feedDao.save(feedback);
		} else throw new UserNotFoundException();
	}
	
	@Override
	public void updateFeedbackbyId(int id, Feedback feedback) {
		if(feedDao.existsById(id)) {
			feedDao.save(feedback);
		} else throw new FeedbackNotFoundException();
	}

	@Override
	public List<Feedback> viewFeedbackList() {
		return feedDao.findAll();
	}

	@Override
	public Feedback viewFeedBackByUser(int userid) {
		if(userDao.existsById(userid)) {
			Users user = userDao.findById(userid).get();
			//return feedDao.findById(userid).get();
			return feedDao.findByUser(user);
		}else throw new UserNotFoundException();
	}


}
