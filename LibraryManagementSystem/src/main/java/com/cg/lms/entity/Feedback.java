package com.cg.lms.entity;

import java.util.Date; 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@SequenceGenerator(name = "myFeedback",sequenceName = "myFeedbackSequence01",initialValue = 1)
	@GeneratedValue(generator = "myFeedback")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private Users user;
	
	private Date feedbackDate;
	private String description;
	private String rating;
	private String comments;
	
	public Feedback() {
		super();
	}
	
	public Feedback(int id, Users user, Date feedbackDate, String description, String rating, String comments) {
		super();
		this.id = id;
		this.user = user;
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}

	public int getId() {
		return id;
	} 
	
	public void setId(int id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	
	public void setUser(Users user) {
		this.user = user;
	}
	
	public Date getFeedbackDate() {
		return feedbackDate;
	}
	
	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
}
