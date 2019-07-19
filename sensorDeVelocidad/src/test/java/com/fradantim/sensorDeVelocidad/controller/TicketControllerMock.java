package com.fradantim.sensorDeVelocidad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fradantim.sensorDeVelocidad.persistence.entites.Limite;
import com.fradantim.sensorDeVelocidad.persistence.service.LimiteService;

import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

@Controller(value="TicketControllerMock")
public class TicketControllerMock extends TicketController{
	
	private static final Logger logger = LoggerFactory.getLogger(TicketControllerMock.class);
	
	@Autowired
	private LimiteService limiteService;
	
	public void evaluarVehiculoClima(DatosVehiculo datosVehiculo, TipoClima tipoClima) {
		logger.info("MOCK! Evaluo: PATENTE:"+datosVehiculo.patente);
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
				logger.debug("\tTicket NO guardado (MOCK)~~~");
			} else {
				logger.debug("\tVehiculo no supera limite ("+(datosVehiculo.velocidadMedida-limite.getValue())+")");
			}
		}
	}
}