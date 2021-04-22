package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Feedback;
import com.cg.lms.entity.Publishers;
import com.cg.lms.service.FeedbackServiceI;

@RestController
@RequestMapping(value = "/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackServiceI feedbackService;
	
	@PostMapping(value = "/addNewFeedback")
	public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback) {
		feedbackService.writeFeedback(feedback);
		return new ResponseEntity<String>("Inserted", HttpStatus.OK);
	}
	
	@PostMapping(value = "/updateFeedback/{id}")
	public ResponseEntity<Object> updateFeedback(@PathVariable int id, @RequestBody Feedback feedback) {
		feedbackService.updateFeedbackbyId(id, feedback);
		return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAll")
	public List<Feedback> getAllFeedback() {
		return feedbackService.viewFeedbackList();
	}
	
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable int userid) {
		return new ResponseEntity<Feedback>(feedbackService.viewFeedBackByUser(userid),HttpStatus.OK);
	}
	
	
	
}
