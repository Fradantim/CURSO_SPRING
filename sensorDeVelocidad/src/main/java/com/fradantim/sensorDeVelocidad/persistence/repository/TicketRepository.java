package com.fradantim.sensorDeVelocidad.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fradantim.sensorDeVelocidad.persistence.dao.TicketDao;
import com.fradantim.sensorDeVelocidad.persistence.entites.Ticket;

@Repository(value="TicketRepository")
public interface TicketRepository extends JpaRepository<Ticket, Integer>, TicketDao {
	
}