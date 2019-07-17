package com.fradantim.sensorDeVelocidad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.fradantim.sensorDeVelocidad.persistence.entites.Limite;
import com.fradantim.sensorDeVelocidad.persistence.entites.Ticket;
import com.fradantim.sensorDeVelocidad.persistence.service.ClimaService;
import com.fradantim.sensorDeVelocidad.persistence.service.LimiteService;
import com.fradantim.sensorDeVelocidad.persistence.service.TicketService;
import com.fradantim.sensorDeVelocidad.persistence.service.VehiculoService;

import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

@Controller
public class TicketController{
	
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	
	@Autowired
	private LimiteService limiteService;

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private ClimaService climaService;
	
	//Traigo el Interceptor que implementa VehiculoService
	@Autowired
	@Qualifier("VehiculoServiceI")
	private VehiculoService vehiculoService;
	
	public void init() {
		sensar();
	}

	private void sensar() {
		long index = 0;
		while (true) {
			DatosVehiculo datosVehiculo = vehiculoService.getDatosVehiculo();
			TipoClima tipoClima = climaService.getTipoClima();
			logger.debug("Sensando nro "+index);
			evaluarVehiculoClima(datosVehiculo, tipoClima);
			index++;
		}
	}
	
	public void evaluarVehiculoClima(DatosVehiculo datosVehiculo, TipoClima tipoClima) {
		logger.debug("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
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
				ticketService.save(t);
				logger.debug("\tTicket guardado~~~");
			} else {
				logger.debug("\tVehiculo no supera limite ("+(datosVehiculo.velocidadMedida-limite.getValue())+")");
			}
		}
	}
}