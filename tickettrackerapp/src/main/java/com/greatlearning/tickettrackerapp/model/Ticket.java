package com.greatlearning.tickettrackerapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ticket_tracker_db")
@Data
public class Ticket {
	@Column(name="sl_no")
	private int serialNumber;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int id;
	@Column(name="ticket_title")
	private String ticketTitle;
	@Column(name="ticket_short_description")
	private String ticketDescription;
	@Column(name="ticket_booking_date")
	private String ticketDate;
}
