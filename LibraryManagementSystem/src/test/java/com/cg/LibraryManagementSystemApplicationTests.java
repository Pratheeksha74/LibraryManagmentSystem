package com.cg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.cg.lms.dao.FeedbackDao;
//import com.cg.lms.dao.UsersDao;
import com.cg.lms.entity.Feedback;
import com.cg.lms.entity.Publishers;
//import com.cg.lms.entity.Users;
import com.cg.lms.exception.FeedbackNotFoundException;
import com.cg.lms.exception.PublisherNotFoundException;
import com.cg.lms.service.FeedbackServiceI;
import com.cg.lms.service.PublisherServiceI;

	@SpringBootTest
	class LibraryManagementSystemApplicationTests {
	
		@Autowired
		PublisherServiceI publisherserviceI;
		
		@Autowired
		FeedbackServiceI feedbackServiceI;
		
		@Test
		void addPublisherTest() {
			Publishers publisher = new Publishers("MU Publisher", "9872343214","mu12@gmail.com","street 12","street 1","Horil","Delhi",654221);
			publisherserviceI.addPublisher(publisher);
			assertThat(publisher.getPublisherId()).isGreaterThan(0);
		}
		
		@Test
		void addPublisherTestWithName() {
			Publishers publisher = new Publishers("MU Publisher", "9872343214","mu12@gmail.com","street 12","street 1","Horil","Delhi",654221);
			//publisherserviceI.addPublisher(publisher);
			assertEquals("MU Publisher", publisherserviceI.addPublisher(publisher).getPublisherName());
		}
		
		@Test
		void updatePublisherTestForException() {
			assertThrows(PublisherNotFoundException.class, ()->publisherserviceI.updatePublisherDetails(7, new Publishers("Read Us","8932564181","readUs@gmail.com","street 2","Ganesh temple road","Bangalore","Karnataka",443289)));
		}
		
		@Test
		void GivenIdupdatePublisherThenShouldUpdateTheField() {
			Publishers publisher = new Publishers("Read Us","8932564181","readBooks@gmail.com","street 2","Ganesh temple road","Bangalore","Karnataka",443289);
			publisherserviceI.updatePublisherDetails(45, publisher);
			assertEquals("readBooks@gmail.com",publisher.getEmail());
		}
		
		@Test
		void getPublisherByIdTest() {
			Publishers publisher = new Publishers("Akash Publisher", "9872343214","akash@gmail.com","street 10","street 1","Madikeri","Karnataka",654271);
			publisherserviceI.addPublisher(publisher);
			Publishers found = publisherserviceI.viewPublisherById(publisher.getPublisherId());
			assertEquals(publisher.getPublisherId(),found.getPublisherId());
		}
		
		@Test
		void givenIdToDeletePublisherThenShouldDeleteThePublisher() {
			Publishers publisher = new Publishers("Ashish Publisher", "9872673214","ashish@gmail.com","street 9","street 2","Mysore","Karnataka",754274);
			publisherserviceI.addPublisher(publisher);
			int id = publisher.getPublisherId();
			publisherserviceI.removePublisher(publisher.getPublisherId());
			assertThrows(PublisherNotFoundException.class, ()->publisherserviceI.viewPublisherById(id));	
		}
		
		@Test
		void updateFeedback() {
			assertThrows(FeedbackNotFoundException.class, ()->feedbackServiceI.updateFeedbackbyId(10, new Feedback(LocalDate.of(2020, 7, 13),"Science","four","Learnt new things")));
		}
		
		@Test
		void viewFeedbackByUser() {
			assertEquals(1, feedbackServiceI.viewFeedBackByUser(1).getUser().getUserid());
		}
		
	}
