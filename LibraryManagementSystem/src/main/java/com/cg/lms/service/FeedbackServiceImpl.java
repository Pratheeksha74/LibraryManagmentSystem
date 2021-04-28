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

/********************************************************************************
 * 
 * Description: This class is used to create services for Feedback
 * @author ASUS
 * Version: v1.1
 * Created 20 April 2021
 * 
 ********************************************************************************/

@Service
public class FeedbackServiceImpl implements FeedbackServiceI {
	@Autowired
	FeedbackDao feedDao;
	
	@Autowired
	UsersDao userDao;
	
	/********************************************************************************
	 * 
	 * Method: addPublisher
	 * Description: This method adds a new Feedback using userid 
	 * @param publisher
	 * @return Publishers
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public Feedback writeFeedback(int userid,Feedback feedback) {
		if(userDao.existsById(userid)) {
			Users users = userDao.findById(userid).get();
			feedback.setUser(users);
			return feedDao.save(feedback);
		} else throw new UserNotFoundException();
	}

	/********************************************************************************
	 * 
	 * Method: updateFeedbackById
	 * Description: This method is used to update feedback
	 * @param id
	 * @param feedback
	 * @return void
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public void updateFeedbackbyId(int id, Feedback feedback) {
		if(feedDao.existsById(id)) {
			feedback.setId(id);
			feedDao.save(feedback);
		} else throw new FeedbackNotFoundException();
	}
	
	/********************************************************************************
	 * 
	 * Method: viewFeedbackList
	 * Description: Returns list of Feedback present in the database
	 * @return List<Feedback>
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public List<Feedback> viewFeedbackList() {
		return feedDao.findAll();
	}
	
	/********************************************************************************
	 * 
	 * Method: viewFeedBackByUser
	 * Description: This method is used view the Feedback By passing userid
	 * @param userid
	 * @return Feedback
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/

	@Override
	public Feedback viewFeedBackByUser(int userid) {
		if(userDao.existsById(userid)) {
			Users user = userDao.findById(userid).get();
			return feedDao.findByUser(user);
		}else throw new UserNotFoundException();
	}


}
