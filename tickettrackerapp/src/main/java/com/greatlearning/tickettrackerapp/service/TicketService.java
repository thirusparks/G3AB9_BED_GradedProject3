package com.greatlearning.tickettrackerapp.service;

import java.util.List;

import com.greatlearning.tickettrackerapp.model.Ticket;

public interface TicketService {

	public List<Ticket> getAllTickets();
	public void saveOrUpdate(Ticket tick);
	public void deleteTicketById(int id);
	public Ticket getTicketById(int id);
	
}
