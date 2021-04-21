package com.cg;

import java.util.Date;

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
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Users u1 = new Users(1,"aed","Ahana","Rai","6789543217","ahana@gmail.com",new Date(18/02/2004),new Date(2/02/2020),new Date(2/03/2020),"Subscibed");
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
		
		
	}

}
