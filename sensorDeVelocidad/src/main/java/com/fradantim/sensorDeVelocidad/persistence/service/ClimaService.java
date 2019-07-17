package com.fradantim.sensorDeVelocidad.persistence.service;

import org.springframework.stereotype.Service;

import sensorclima.TipoClima;

@Service
public class ClimaService {
	
	private sensorclima.Sensor sensorClima = new sensorclima.Sensor();
	
	public TipoClima getTipoClima() {
		return sensorClima.sensar();
	}
}
