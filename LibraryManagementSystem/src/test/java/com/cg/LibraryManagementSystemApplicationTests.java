package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Publishers;
import com.cg.lms.exception.PublisherNotFoundException;
import com.cg.lms.service.PublisherServiceI;

@SpringBootTest
class LibraryManagementSystemApplicationTests {

	@Autowired
	PublisherServiceI publisherserviceI;
	
	@Test
	void addPublisherTest() {
		Publishers publisher = new Publishers("MU Publisher", "9872343214","mu12@gmail.com","street 12","street 1","Horil","Delhi",654221);
		assertEquals("MU Publisher", publisherserviceI.addPublisher(publisher).getPublisherName());
	}
	
	@Test
	void updateTest() {
		assertThrows(PublisherNotFoundException.class, ()->publisherserviceI.updatePublisherDetails(7, new Publishers("Read Us","8932564181","readUs@gmail.com","	street 2","	Ganesh temple road","Bangalore","	Karnataka",443289)));
	}

}
