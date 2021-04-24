package com.cg.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.lms.entity.Publishers;
import com.cg.lms.exception.PublisherNotFoundException;

@Service
public interface PublisherServiceI {
	public Publishers addPublisher(Publishers publisher);
	public void updatePublisherDetails(int publisherId,Publishers publisher) throws PublisherNotFoundException ;
	public void removePublisher(int publisherId) throws PublisherNotFoundException;
	public List<Publishers> viewPublishersList();
	public Publishers viewPublisherById(int id);
}
