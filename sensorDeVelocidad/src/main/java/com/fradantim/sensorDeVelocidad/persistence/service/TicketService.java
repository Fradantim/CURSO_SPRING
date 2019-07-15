package com.fradantim.sensorDeVelocidad.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fradantim.sensorDeVelocidad.persistence.entites.Ticket;
import com.fradantim.sensorDeVelocidad.persistence.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepo;

	public Ticket save(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
}
