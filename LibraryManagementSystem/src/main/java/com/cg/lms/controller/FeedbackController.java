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
import org.springframework.web.bind.annotation.CrossOrigin;
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

/****************************************************************************
 * 
 * @author ASUS
 * Description: This class is used to add,update, get and delete Feedback
 * Version: v1.1
 * Created 20 April 2021
 * 
 ****************************************************************************/

@Api("Feedback Controller")
@RestController
@RequestMapping(value = "/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackServiceI feedbackService;
	
	/****************************************************************************
	 * 
	 * Method: addFeedback
	 * Description: This method is used to add new Feedback
	 * @PathVariable: Used to inject values from the URL into a method parameter. 
	 * @param id
	 * @param feedback
	 * @param bindingResult
	 * @PostMapping: 
	 * @return ResponseEntity<String>
	 * @throws MethodArgumentNotValidException
	 * Created 20 April 2021
	 * 
	 ****************************************************************************/
	
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
	
	/****************************************************************************
	 * 
	 * Method: updateFeedback
	 * Description: This method is used to update feedback
	 * @param id
	 * @RequestBody: bind the incoming HTTP request body to that methods parameter.
	 * @param feedback
	 * @PostMapping: 
	 * @return ResponseEntity<Object>
	 * Created 20 April 2021
	 * 
	 ****************************************************************************/
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
	
	/****************************************************************************
	 * 
	 * Method: getAllFeedback
	 * Description: This method is used to get all Feedback
	 * @return List<Feedback>
	 * Created 20 April 2021
	 * 
	 ****************************************************************************/

	@ApiOperation(value = "get all feedback")
	@GetMapping(value = "/getAllFeedback")
	public List<Feedback> getAllFeedback() {
		return feedbackService.viewFeedbackList();
	}
	
	/****************************************************************************
	 * 
	 * Method: getFeedbackById
	 * Description: This method is used to get Feedback by Id
	 * @param userid
	 * @return ResponseEntity<Feedback>
	 * Created 20 April 2021
	 * 
	 ****************************************************************************/
	
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
