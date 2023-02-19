package com.greatlearning.tickettrackerapp.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tickettrackerapp.model.Ticket;
import com.greatlearning.tickettrackerapp.service.TicketService;


@Controller
public class TicketController {

	@Autowired
	TicketService service;
	
	/*
	 * /tickets
	 * /tickets/new
	 * /tickets/edit/{id}
	 * /tickets/delete/{id}
	 * /list_of_tickets POST
	 * /tickets/edit/{id} POST
	 */
	
	@GetMapping("/tickets")
	public String getAllTickets(Model model) {
		List<Ticket> results = service.getAllTickets();
		model.addAttribute("tickets", results);
		return "list_of_tickets";
	}
	
	@GetMapping("/tickets/new")
	public String addNewTicket(Model model) {
		Ticket result = new Ticket();
		model.addAttribute("ticket", result);
		return "create_ticket";
	}
	
	@GetMapping("/tickets/edit/{id}")
	public String editTicket(Model model, @PathVariable("id") int id) {
		Ticket result = service.getTicketById(id);
		model.addAttribute("ticket", result);
		return "edit_ticket";
	}
	
	@GetMapping("/tickets/delete/{id}")
	public String deleteTicket(@PathVariable("id") int id) {
		service.deleteTicketById(id);
		return "redirect:/list_of_tickets";
	}
	
	@PostMapping("/tickets")
	public String saveNewTicket(@ModelAttribute("ticket") Ticket tick){
		service.saveOrUpdate(tick);
		return "redirect: /list_of_tickets";
	}
	
	@PostMapping("/tickets/{id}")
	public String updateTicket(@ModelAttribute("ticket") Ticket tick, @PathVariable("id") int id){
		Ticket existingTicket = service.getTicketById(id);
		existingTicket.setTicketTitle(tick.getTicketTitle());
		existingTicket.setSerialNumber(tick.getSerialNumber());
		existingTicket.setTicketDescription(tick.getTicketDescription());
		existingTicket.setTicketDate(tick.getTicketDate());
		service.saveOrUpdate(tick);
		return "redirect: /list_of_tickets";
	}
	
}
