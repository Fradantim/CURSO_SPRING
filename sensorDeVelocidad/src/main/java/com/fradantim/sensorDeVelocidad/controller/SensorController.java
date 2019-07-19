package com.fradantim.sensorDeVelocidad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.fradantim.sensorDeVelocidad.persistence.service.ClimaService;
import com.fradantim.sensorDeVelocidad.persistence.service.VehiculoService;

import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

@Controller
public class SensorController{
	
	private static final Logger logger = LoggerFactory.getLogger(SensorController.class);
	
	@Autowired
	private ClimaService climaService;
	
	//Traigo el Interceptor que implementa VehiculoService
	@Autowired
	@Qualifier("VehiculoServiceI")
	private VehiculoService vehiculoService;
	
	private TicketController ticketController;
	
	/* uso injeccion en constructor para que la clase main instancie 
	 * la implementacion concreta, y que la clase test instancie
	 *  la implementacion mock
	 */
	@Autowired
	public SensorController(TicketController ticketController) {
		this.ticketController=ticketController;
	}
	
	public void init() {
		logger.info("Se inicia el Sensor infinito");
		while (true) {
			sensar();
		}
	}
	
	public void sensar() {
		logger.info("-+-+-+-+-+-+-+-+-+-+-+-+-+-");
		logger.info("Sensando vehiculo.");
		DatosVehiculo datosVehiculo = vehiculoService.getDatosVehiculo();
		logger.info("Sensando clima.");
		TipoClima tipoClima = climaService.getTipoClima();
		logger.info("Envio a evaluador.");
		ticketController.evaluarVehiculoClima(datosVehiculo, tipoClima);
	}
}