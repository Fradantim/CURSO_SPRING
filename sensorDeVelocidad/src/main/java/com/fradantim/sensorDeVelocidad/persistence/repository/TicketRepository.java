package com.fradantim.sensorDeVelocidad.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fradantim.sensorDeVelocidad.persistence.entites.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
}