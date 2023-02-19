package com.greatlearning.tickettrackerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tickettrackerapp.model.Ticket;
import com.greatlearning.tickettrackerapp.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository repository;
	@Override
	public List<Ticket> getAllTickets() {
		
		return repository.findAll();
	}

	@Override
	public void saveOrUpdate(Ticket tick) {
		repository.save(tick);
		
	}

	@Override
	public void deleteTicketById(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public Ticket getTicketById(int id) {
		
		return repository.findById(id).get();
	}

}
