package com.cg.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.dao.PublisherDao;
import com.cg.lms.entity.Publishers;

@Service
public class PublisherServiceImpl implements PublisherServiceI {
	@Autowired
	PublisherDao publisherDao;
	
	@Override
	public Publishers addPublisher(Publishers publisher) {
		return publisherDao.save(publisher);
	}

	@Override
	public void updatePublisherDetails(int publisherId, Publishers publisher) {
		if(publisherDao.existsById(publisherId)) {
			publisherDao.save(publisher);
		}
	}

	@Override
	public void removePublisher(int publisherId) {
		publisherDao.deleteById(publisherId);
	}

	@Override
	public List<Publishers> viewPublishersList() {
		return publisherDao.findAll();
	}

	@Override
	public Publishers viewPublisherById(int id) {
		return publisherDao.findById(id).get();
	}

}
