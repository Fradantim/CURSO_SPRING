package com.fradantim.sensorDeVelocidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fradantim.sensorDeVelocidad.controller.SensorController;


@SpringBootApplication
public class SensorDeVelocidadApplication implements CommandLineRunner {

	@Autowired
	private SensorController sensorController;
	
	public static void main(String[] args) {
		SpringApplication.run(SensorDeVelocidadApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sensorController.init();
	}
}
