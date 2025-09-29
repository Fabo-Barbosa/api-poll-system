package br.com.fabo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabo.model.Poll;
import br.com.fabo.services.PollServices;

@RestController
@RequestMapping(value = "poll")
public class PollController {
	
	@Autowired
	private PollServices service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Poll> findAll() throws Exception {
		
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Poll getById(@PathVariable(value = "id") Long idPoll) throws Exception {
		
		return service.getById(idPoll);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Poll create(@RequestBody Poll poll) throws Exception {
		
		if (poll.getTopics() != null) {
			poll.getTopics().forEach(topic -> poll.addTopic(topic));
		}
		
		return service.createPoll(poll);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Poll update(@RequestBody Poll poll) throws Exception {
		
		return service.updatePoll(poll);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long idPoll) {
		
		service.deletePoll(idPoll);
		return ResponseEntity.noContent().build();
	}
}
