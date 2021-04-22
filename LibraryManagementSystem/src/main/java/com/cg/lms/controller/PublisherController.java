package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Publishers;
import com.cg.lms.service.PublisherServiceI;

@RestController
@RequestMapping(value = "/publisher")
public class PublisherController {
	@Autowired
	PublisherServiceI publisherService;
	
	@PostMapping(value = "/addNewPublisher")
	public ResponseEntity<String> addPublisher(@RequestBody Publishers publisher){
		publisherService.addPublisher(publisher);
		return new ResponseEntity<String>("Inserted Successfully",HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAll")
	public List<Publishers> getAllPublishers() {
		return publisherService.viewPublishersList();
	}
	
	@GetMapping(value = "/getById/{id}")
	public ResponseEntity<Publishers> getPublisherById(@PathVariable int id) {
		return new ResponseEntity<Publishers>(publisherService.viewPublisherById(id),HttpStatus.OK);
	}
	
	@PostMapping(value = "/updatePublisher/{id}")
	public ResponseEntity<Object> updatePublishers(@PathVariable int id, @RequestBody Publishers publisher) {
		publisherService.updatePublisherDetails(id, publisher);
		return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<String> deletePublisherById(@PathVariable int id) {
		publisherService.removePublisher(id);
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}

}
