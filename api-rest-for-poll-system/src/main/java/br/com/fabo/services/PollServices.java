package br.com.fabo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabo.model.Poll;
import repositories.PollRepository;

@Service
public class PollServices {
	
	private final Logger logger = Logger.getLogger(PollServices.class.getName());
	
	@Autowired
	PollRepository repository;
	
	public List<Poll> findAll() {
		logger.info("Find all registred polls.");
		
		return repository.findAll();
	}
	
	
}
