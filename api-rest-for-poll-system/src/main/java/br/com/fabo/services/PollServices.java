package br.com.fabo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabo.exceptions.ResourceNotFoundException;
import br.com.fabo.model.Poll;
import br.com.fabo.repositories.PollRepository;

@Service
public class PollServices {
	
	private final Logger logger = Logger.getLogger(PollServices.class.getName());
	
	@Autowired
	PollRepository repository;
	
	public List<Poll> findAll() {
		logger.info("Find all registred polls.");
		
		return repository.findAll();
	}
	
	public Poll getById(Long id) {
		logger.info("Find new poll by ID");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records founds for this ID"));
	}
	
	public Poll createPoll(Poll poll) {
		logger.info("Creating a new poll");
		return repository.save(poll);
	}
	
	public Poll updatePoll(Poll poll) {
		logger.info("Updating poll...");
		
		var entity = repository.findById(poll.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records finds for this ID"));
		entity.setTitle(poll.getTitle());
		entity.setDescription(poll.getDescription());
		entity.setTopics(poll.getTopics());
		
		return repository.save(poll);
	}
	
	public void deletePoll(Long id) {
		logger.info("Deleting a poll");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records finds for this ID"));
		repository.delete(entity);
	}
	
}
