package com.cg.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.dao.PublisherDao;
import com.cg.lms.entity.Publishers;
import com.cg.lms.exception.PublisherNotFoundException;

/********************************************************************************
 * 
 * Description: This class is used to create services for Publisher
 * @author ASUS
 * Version: v1.1
 * Created 20 April 2021
 * 
 ********************************************************************************/

@Service
public class PublisherServiceImpl implements PublisherServiceI {
	@Autowired
	PublisherDao publisherDao;
	
	/********************************************************************************
	 * 
	 * Method: addPublisher
	 * Description: This method adds a new Publisher 
	 * @param publisher
	 * @return Publishers
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public Publishers addPublisher(Publishers publisher) {
		return publisherDao.save(publisher);
	}

	/********************************************************************************
	 * 
	 * Method: updatePublisherDetails
	 * Description: This method updates the publisher using Id
	 * @param publisherId
	 * @param publisher
	 * @return void
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public void updatePublisherDetails(int publisherId, Publishers publisher){
		if(publisherDao.existsById(publisherId)) {
			publisher.setPublisherId(publisherId);
			publisherDao.save(publisher);
		} else throw new PublisherNotFoundException();
	}
	
	/********************************************************************************
	 * 
	 * Method: removePublisher
	 * Description: This method is used to remove the publisher using Id
	 * @param publisherId
	 * @return void
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/

	@Override
	public void removePublisher(int publisherId){
		if(publisherDao.existsById(publisherId)) {
			publisherDao.deleteById(publisherId);
		} else throw new PublisherNotFoundException();
	}
	
	/********************************************************************************
	 * 
	 * Method: viewPublishersList
	 * Description: This method returns List of Publishers present in the database
	 * @param publisherId
	 * @return List<Publishers>
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/

	@Override
	public List<Publishers> viewPublishersList() {
		return publisherDao.findAll();
	}
	
	/********************************************************************************
	 * 
	 * Method: viewPublisherById
	 * Description: This method is used to view the publisher by Id
	 * @param id
	 * @return Publishers
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/

	@Override
	public Publishers viewPublisherById(int id){
		if(publisherDao.existsById(id)) {
			return publisherDao.findById(id).get();
		} else throw new PublisherNotFoundException();
	}
	
	

}
