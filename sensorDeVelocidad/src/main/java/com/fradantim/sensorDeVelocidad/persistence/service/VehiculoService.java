package com.fradantim.sensorDeVelocidad.persistence.service;

import org.springframework.stereotype.Service;

import sensorvelocidad.DatosVehiculo;

@Service
public class VehiculoService {
	
	private sensorvelocidad.Sensor sensorVelocidad = new sensorvelocidad.Sensor();
	
	public 	DatosVehiculo getDatosVehiculo() {
		return sensorVelocidad.sensarVehiculo();
	}
}
