package com.fradantim.sensorDeVelocidad.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fradantim.sensorDeVelocidad.persistence.entites.Limite;
import com.fradantim.sensorDeVelocidad.persistence.entites.Ticket;
import com.fradantim.sensorDeVelocidad.persistence.service.LimiteService;
import com.fradantim.sensorDeVelocidad.persistence.service.TicketService;

import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

@Component
public class StartUpController implements InitializingBean {
	
	private static final Logger logger = LoggerFactory.getLogger(StartUpController.class);
	
	private final static String CSV_DELIMITER = ",";
	
	private static final int INDEX_CLIMA = 0;
	private static final int INDEX_TIPO_VEHICULO = 1;
	private static final int INDEX_VALUE= 2;
	
	@Autowired
	private LimiteService limiteService;

	@Autowired
	private TicketService ticketService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		cargarBBDD();
		sensar();
	}
	
	private void cargarBBDD() {
		logger.info("Evaluando estado de la BBDD.");
		if(limiteService.getCount().equals(0)) {
			logger.info("No hay elementos en la BBDD.");
			BufferedReader reader;
			try {
				logger.info("INI CARGA DE LIMITES -------------------------------");
				reader = new BufferedReader(new FileReader(new ClassPathResource("csvdata/tarifas.csv").getFile()));
				String line = reader.readLine();
				while (line != null) {
					String[] campos = line.split(CSV_DELIMITER);
					Limite limite = new Limite(new Integer(campos[INDEX_VALUE]), campos[INDEX_TIPO_VEHICULO],  campos[INDEX_CLIMA]); 
					limiteService.save(limite);
					line = reader.readLine();					
				}
				reader.close();
				logger.info("FIN CARGA DE LIMITES -------------------------------");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void sensar() {
		sensorvelocidad.Sensor sensorVelocidad = new sensorvelocidad.Sensor();
		sensorclima.Sensor sensorClima = new sensorclima.Sensor();
		long index = 0;
		while (true) {
			DatosVehiculo datosVehiculo = sensorVelocidad.sensarVehiculo();
			TipoClima tipoClima = sensorClima.sensar();
			System.out.println(index);
			System.out.println("\t"+"PATENTE:"+datosVehiculo.patente);
			System.out.println("\t"+"VELOCIDAD:"+datosVehiculo.velocidadMedida);
			System.out.println("\t"+"TIPO VE:"+datosVehiculo.tipoVehiculo);
			System.out.println("\t"+"CLIMA:"+tipoClima.name());
			
			Limite limite = limiteService.findByTipoVehiculoAndTipoClima(datosVehiculo.tipoVehiculo.name(), tipoClima.name());
			if(limite==null) {
				System.out.println("No se encontro limite!!!!!!! ----------");
			} else {
				System.out.println("\tLimite encontrado:"+limite.getValue());
				if(datosVehiculo.velocidadMedida > limite.getValue() ) {
					System.out.println("\tVehiculo supera limite! (+"+(datosVehiculo.velocidadMedida-limite.getValue())+")");
					Ticket t = new Ticket(datosVehiculo.patente, datosVehiculo.velocidadMedida, datosVehiculo.tipoVehiculo.name(), limite);
					ticketService.save(t);
					System.out.println("\tTicket guardado~~~");
				} else {
					
				}
			}
			index++;
			
			System.out.println();
		}
	}
}