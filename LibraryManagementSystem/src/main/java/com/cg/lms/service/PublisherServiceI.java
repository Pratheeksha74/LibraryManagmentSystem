package com.cg.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.lms.entity.Publishers;

@Service
public interface PublisherServiceI {
	public Publishers addPublisher(Publishers publisher);
	public void updatePublisherDetails(int publisherId,Publishers publisher);
	public void removePublisher(int publisherId);
	public List<Publishers> viewPublishersList();
	public Publishers viewPublisherById(int id);
}
