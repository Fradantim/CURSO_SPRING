package com.fradantim.sensorDeVelocidad.persistence.dao.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fradantim.sensorDeVelocidad.persistence.dao.TicketDao;
import com.fradantim.sensorDeVelocidad.persistence.entites.Ticket;

@Component(value="TicketDaoI")
public class TicketDaoInterceptor implements TicketDao{

	@Autowired
	@Qualifier("TicketRepository")
	private TicketDao ticketRepo;

	@Autowired
	@Qualifier("TicketFileCreator")
	private TicketDao ticketFileCreator;
	
	public Ticket save(Ticket ticket) {
		ticketFileCreator.save(ticket);
		return ticketRepo.save(ticket);
	}
}
