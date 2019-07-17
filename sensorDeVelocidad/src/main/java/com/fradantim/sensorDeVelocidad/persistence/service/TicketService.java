package com.fradantim.sensorDeVelocidad.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fradantim.sensorDeVelocidad.persistence.dao.TicketDao;
import com.fradantim.sensorDeVelocidad.persistence.entites.Ticket;

@Service
public class TicketService {
	
	@Autowired
	@Qualifier("TicketDaoI")
	private TicketDao ticketDao;

	public Ticket save(Ticket ticket) {
		return ticketDao.save(ticket);
	}
}
