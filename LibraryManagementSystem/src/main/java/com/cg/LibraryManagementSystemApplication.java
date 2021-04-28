package com.cg;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.lms.dao.BooksDao;
import com.cg.lms.dao.BooksOrderDao;
import com.cg.lms.dao.FeedbackDao;
import com.cg.lms.dao.PublisherDao;
import com.cg.lms.dao.UsersDao;
import com.cg.lms.entity.Books;
import com.cg.lms.entity.BooksOrder;
import com.cg.lms.entity.Feedback;
import com.cg.lms.entity.Publishers;
import com.cg.lms.entity.Users;
import com.cg.lms.service.FeedbackServiceI;
import com.cg.lms.service.PublisherServiceI;

@SpringBootApplication
public class LibraryManagementSystemApplication implements CommandLineRunner{
	@Autowired
	UsersDao daoU;
	
	@Autowired
	FeedbackDao daoF;
	
	@Autowired
	BooksDao daoB;
	
	@Autowired
	BooksOrderDao daoBO;
	
	@Autowired
	PublisherDao daoP;
	
	@Autowired
	PublisherServiceI publisherserviceI;
	
	@Autowired
	FeedbackServiceI feedbackServiceI;
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Users u1 = new Users("risha@12","Risha","Park","2376129876","risha@gmail.com",LocalDate.of(1995,10,4),LocalDate.of(2020,12,4),LocalDate.of(2021,1,4),"Not Subscibed");
//		daoU.save(u1);
//		System.out.println("Users saved");
//		Feedback f1 = new Feedback(1,u1,new Date(25/02/2020),"Good Book","five","wow");
//		daoF.save(f1);
//		System.out.println("saved feedback");
//		
//		Books b1 = new Books(1,"Advanced Java","Java","Stunning man","MacGraw Hill",2020,"1234",16,345.67,"fourth right");
//		daoB.save(b1);
//		System.out.println("Books saved");
//		Publishers p1 = new Publishers(1,"MacGraw Hill","6732564189","mac@gmail.com","street 1","bull temple road","Mangalore","Karnataka",543287);
//		daoP.save(p1);
//		System.out.println("Publishers saved");
//		BooksOrder bo1 = new BooksOrder(1,b1,p1,2,new Date(12/05/2020),"Delivered");
//		daoBO.save(bo1);
//		System.out.println("BooksOrder saved");
//		Publishers publisher = new Publishers("Akash Publisher", "9872343214","akash@gmail.com","street 10","street 1","Madikeri","Karnataka",654271);
//		publisherserviceI.addPublisher(publisher);
//		Publishers found = publisherserviceI.viewPublisherById(publisher.getPublisherId());
//		System.out.println("publisher "+ publisher.getPublisherId());
//		System.out.println("found "+ found.getPublisherId());
//		Publishers publisher = new Publishers("Ashish Publisher", "9872673214","ashish@gmail.com","street 9","street 2","Mysore","Karnataka",754274);
//		publisherserviceI.addPublisher(publisher);
//		System.out.println("Added");
//		publisherserviceI.removePublisher(publisher.getPublisherId());
//		System.out.println("Removed");
		
//		Users user = new Users("abc123","Araa","Sharma","9876876576","aaaa@gmail.com",LocalDate.of(2000, 1, 12),LocalDate.of(2021, 3, 24),LocalDate.of(2021, 4, 24),"Not Subscribed");
//		daoU.save(user);
//		System.out.println("Users inserted");
//		int id = user.getUserid();
//		System.out.println(id);
//		feedbackServiceI.writeFeedback(id,new Feedback(user,LocalDate.of(2020, 7, 13),"Science","four","Learnt new things"));
	}

}
