package com.fradantim.sensorDeVelocidad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fradantim.sensorDeVelocidad.persistence.entites.Limite;
import com.fradantim.sensorDeVelocidad.persistence.entites.Ticket;
import com.fradantim.sensorDeVelocidad.persistence.service.LimiteService;
import com.fradantim.sensorDeVelocidad.persistence.service.TicketService;

import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

@Controller
public class TicketController{
	
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	
	@Autowired
	private LimiteService limiteService;
	
	@Autowired
	private TicketService ticketService;

	public void evaluarVehiculoClima(DatosVehiculo datosVehiculo, TipoClima tipoClima) {
		logger.info("Evaluo: PATENTE:"+datosVehiculo.patente);
		logger.debug("\tVELOCIDAD:"+datosVehiculo.velocidadMedida);
		logger.debug("\tTIPO VE:"+datosVehiculo.tipoVehiculo);
		logger.debug("\tCLIMA:"+tipoClima.name());
		
		Limite limite = limiteService.findByTipoVehiculoAndTipoClima(datosVehiculo.tipoVehiculo.name(), tipoClima.name());
		if(limite==null) {
			logger.error("No se encontro limite!!!!!!! ----------");
		} else {
			logger.debug("\tLimite encontrado:"+limite.getValue());
			if(limite.superaLimite(datosVehiculo)) {
				logger.info("\tVehiculo supera limite! (+"+(datosVehiculo.velocidadMedida-limite.getValue())+")");
				Ticket t = new Ticket(datosVehiculo.patente, datosVehiculo.velocidadMedida, datosVehiculo.tipoVehiculo.name(), limite);
				t=ticketService.save(t);
				logger.debug("\tTicket guardado~~~");
			} else {
				logger.debug("\tVehiculo no supera limite ("+(datosVehiculo.velocidadMedida-limite.getValue())+")");
			}
		}
	}
}