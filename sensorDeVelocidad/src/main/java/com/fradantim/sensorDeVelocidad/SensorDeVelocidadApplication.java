package com.fradantim.sensorDeVelocidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sensorvelocidad.DatosVehiculo;
import sensorvelocidad.Sensor;

@SpringBootApplication
public class SensorDeVelocidadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SensorDeVelocidadApplication.class, args);
		
		Sensor sensorVelocidad = new Sensor();
		while (true) {
			DatosVehiculo datosVehiculo = sensorVelocidad.sensarVehiculo();
			System.out.println("e");
		}
	}

}
