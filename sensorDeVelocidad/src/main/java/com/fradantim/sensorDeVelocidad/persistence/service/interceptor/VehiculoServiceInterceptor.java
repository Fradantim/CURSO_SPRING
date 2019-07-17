package com.fradantim.sensorDeVelocidad.persistence.service.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fradantim.sensorDeVelocidad.persistence.service.VehiculoService;

import sensorvelocidad.DatosVehiculo;

@Service(value="VehiculoServiceI")
public class VehiculoServiceInterceptor extends VehiculoService{
	
	private static final Logger logger = LoggerFactory.getLogger(VehiculoServiceInterceptor.class);
	
	@Autowired
	private VehiculoService vehiculoService;
	// ^ Tengo que componer una clase concreta
	
	public 	DatosVehiculo getDatosVehiculo() {
		logger.info("Se pidio la info de un vehiculo");
		return vehiculoService.getDatosVehiculo();
	}
}
