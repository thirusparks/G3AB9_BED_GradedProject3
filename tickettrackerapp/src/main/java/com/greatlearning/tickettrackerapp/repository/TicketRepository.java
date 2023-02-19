package com.greatlearning.tickettrackerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.tickettrackerapp.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
