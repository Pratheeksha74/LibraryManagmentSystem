package com.cg.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.cg.lms.dao.PublisherDao;
import com.cg.lms.entity.Publishers;
import com.cg.lms.exception.PublisherNotFoundException;

@Service
public class PublisherServiceImpl implements PublisherServiceI {
	@Autowired
	PublisherDao publisherDao;
	
	/**
	 * 
	 * Method: addPublisher
	 * Description: This method adds a new Publisher 
	 * @param publisher
	 * @return Publishers
	 * Created: 20 April 2021
	 * 
	 */
	@Override
	public Publishers addPublisher(Publishers publisher) {
		return publisherDao.save(publisher);
	}

	@Override
	public void updatePublisherDetails(int publisherId, Publishers publisher){
		if(publisherDao.existsById(publisherId)) {
			publisherDao.save(publisher);
		} else throw new PublisherNotFoundException();
	}

	@Override
	public void removePublisher(int publisherId){
		if(publisherDao.existsById(publisherId)) {
			publisherDao.deleteById(publisherId);
		} else throw new PublisherNotFoundException();
	}

	@Override
	public List<Publishers> viewPublishersList() {
		return publisherDao.findAll();
	}

	@Override
	public Publishers viewPublisherById(int id){
		if(publisherDao.existsById(id)) {
			return publisherDao.findById(id).get();
		} else throw new PublisherNotFoundException();
	}

}
