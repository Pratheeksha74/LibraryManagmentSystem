package com.cg.lms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private Users user;
	
	private LocalDate feedbackDate;

	private String description;
	
	@NotEmpty(message = "Rating should not be empty")
	private String rating;

	private String comments;
	
	public Feedback() {
		super();
	}
	
	public Feedback(int id, Users user, LocalDate feedbackDate, String description, String rating, String comments) {
		super();
		this.id = id;
		this.user = user;
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}
	
	public Feedback(Users user, LocalDate feedbackDate, String description, String rating, String comments) {
		super();
		this.user = user;
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}
	
	public Feedback(LocalDate feedbackDate, String description, String rating, String comments) {
		super();
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
	
	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}
	
	public void setFeedbackDate(LocalDate feedbackDate) {
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
