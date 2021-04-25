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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Publishers;
import com.cg.lms.exception.PublisherNotFoundException;
import com.cg.lms.exception.ValidationException;
import com.cg.lms.service.PublisherServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/********************************************************************************
 * 
 * @author ASUS
 * Description: This class is used to add,update, get and delete publishers
 * Version: v1.1
 * Created 20 April 2021
 * 
 ********************************************************************************/

@Api("Publisher Controller")
@RestController
@RequestMapping(value = "/publisher")
public class PublisherController {
	@Autowired
	PublisherServiceI publisherService;
	
	/****************************************************************************
	 * 
	 * Method: addPublisher
	 * Description: This method adds a new Publisher 
	 * @param publisher
	 * @param bindingResult
	 * @return ResponseEntity<String>
	 * @throws MethodArgumentNotValidException
	 * @PostMapping: 
	 * Created: 20 April 2021
	 * 
	  ****************************************************************************/
	
	@ApiOperation(value = "add new publisher")
	@PostMapping(value = "/addNewPublisher")
	public ResponseEntity<String> addPublisher(@Valid @RequestBody Publishers publisher, BindingResult bindingResult) throws MethodArgumentNotValidException{
		if(bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			System.out.println(errors);
			List<String> errorlist = new ArrayList<String>();
			for(FieldError err: errors) {
				errorlist.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorlist);
		}
		publisherService.addPublisher(publisher);
		return new ResponseEntity<String>("Inserted Successfully",HttpStatus.OK);
	}
	
	
	/****************************************************************************
	 * 
	 * Method: getAllPublishers
	 * Description: Displays all publishers 
	 * @return List<Publishers>
	 * @GetMapping: 
	 * Created: 20 April 2021
	 * 
	 ****************************************************************************/
	
	@ApiOperation(value = "get all publishers")
	@GetMapping(value = "/getAll")
	public List<Publishers> getAllPublishers() {
		return publisherService.viewPublishersList();
	}
	
	/****************************************************************************
	 * 
	 * Method: getPublisherById
	 * Description: Displays publisher by Id
	 * @param id
	 * @GetMapping:
	 * @return ResponseEntity<Publishers>
	 * Created: 20 April 2021
	 * 
	 ****************************************************************************/
	
	@ApiOperation(value = "get publisher by id")
	@GetMapping(value = "/getById/{id}")
	public ResponseEntity<Publishers> getPublisherById(@PathVariable int id) {
		try {
			return new ResponseEntity<Publishers>(publisherService.viewPublisherById(id),HttpStatus.OK);
		} catch (PublisherNotFoundException e) {
			throw new PublisherNotFoundException("Publisher doesn't exists");
		}
	}
	
	
	/****************************************************************************
	 * 
	 * Method: updatePublisher
	 * Description: Updates Publisher by Id
	 * @param id
	 * @param publisher
	 * @param bindingResult
	 * @PostMapping: 
	 * @return ResponseEntity<Object>
	 * @throws MethodArgumentNotValidException
	 * Created: 20 April 2021
	 * 
	 ****************************************************************************/
	
	@ApiOperation(value = "update publisher")
	@PostMapping(value = "/updatePublisher/{id}")
	public ResponseEntity<Object> updatePublishers(@Valid @PathVariable int id, @RequestBody Publishers publisher, BindingResult bindingResult) throws MethodArgumentNotValidException{
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
			publisherService.updatePublisherDetails(id, publisher);
			return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		}catch(PublisherNotFoundException e) {
			throw new PublisherNotFoundException("Publisher doesn't exists");
		}
	}
	
	/****************************************************************************
	 * 
	 * Method: deletePublisher
	 * Description: Deletes Publisher by Id
	 * @param id
	 * @DeleteMapping: 
	 * @return ResponseEntity<String>
	 * Created: 20 April 2021
	 * 
	 ****************************************************************************/
	
	@ApiOperation(value = "delete publisher")
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<String> deletePublisherById(@PathVariable int id) {
		try {
			publisherService.removePublisher(id);
			return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
		} catch (PublisherNotFoundException e) {
			throw new PublisherNotFoundException("Publisher doesn't exists");
		}
	}

}
