package com.cg.lms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Feedback;
import com.cg.lms.exception.FeedbackNotFoundException;
import com.cg.lms.exception.UserNotFoundException;
import com.cg.lms.exception.ValidationException;
import com.cg.lms.service.FeedbackServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Feedback Controller")
@RestController
@RequestMapping(value = "/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackServiceI feedbackService;
	
	//ADDING NEW FEEDBACK
	@ApiOperation(value = "add feedback")
	@PostMapping(value = "/addNewFeedback/{id}")
	public ResponseEntity<String> addFeedback(@Valid @PathVariable int id, @RequestBody Feedback feedback, BindingResult bindingResult) throws MethodArgumentNotValidException{
		if(bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			System.out.println(errors);
			List<String> errorlist = new ArrayList<String>();
			for(FieldError err: errors) {
				errorlist.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorlist);
		}
		try {
			feedbackService.writeFeedback(id,feedback);
		}catch(UserNotFoundException e) {
			throw new UserNotFoundException("No such user found");
		}
		return new ResponseEntity<String>("Inserted", HttpStatus.OK);
	}
	
	
	//UPDATE FEEDBACK
	@ApiOperation(value = "update feedback")
	@PostMapping(value = "/updateFeedback/{id}")
	public ResponseEntity<Object> updateFeedback(@PathVariable int id, @RequestBody Feedback feedback){
		try {
			feedbackService.updateFeedbackbyId(id, feedback);
			return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		}catch(FeedbackNotFoundException e) {
			throw new FeedbackNotFoundException("Feedback from the user doesn't exist");
		}
	}
	
	
	//GET ALL FEEDBACK
	@ApiOperation(value = "get all feedback")
	@GetMapping(value = "/getAllFeedback")
	public List<Feedback> getAllFeedback() {
		return feedbackService.viewFeedbackList();
	}
	
	
	//GET FEEDBACK BY USERID
	@ApiOperation(value = "get feedback by userid")
	@GetMapping(value = "/getById/{userid}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable int userid) {
		try {
			return new ResponseEntity<Feedback>(feedbackService.viewFeedBackByUser(userid),HttpStatus.OK);
		}catch(UserNotFoundException e) {
			throw new UserNotFoundException("No user Found");
		}
	}
	
	
	
}
