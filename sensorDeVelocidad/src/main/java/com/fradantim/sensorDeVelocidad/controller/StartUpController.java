package com.fradantim.sensorDeVelocidad.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fradantim.sensorDeVelocidad.persistence.entites.Limite;

@Component
public class StartUpController implements InitializingBean {
	
	private static final Logger logger = LoggerFactory.getLogger(StartUpController.class);
	
	private final static String CSV_DELIMITER = ",";
	
	private static final int INDEX_CLIMA = 0;
	private static final int INDEX_TIPO_VEHICULO = 1;
	private static final int INDEX_VALUE= 2;

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("Evaluando estado de la BBDD.");
		//TODO CAMBIAR VERIFICACION
		if(new Object() != null) {
			logger.info("No hay elementos en la BBDD.");
			BufferedReader reader;
			try {
				logger.info("CARGA DE LIMITES -------------------------------");
				reader = new BufferedReader(new FileReader(new ClassPathResource("csvdata/tarifas.csv").getFile()));
				String line = reader.readLine();
				while (line != null) {
					line = reader.readLine();
					String[] campos = line.split(CSV_DELIMITER);
					Limite limite = new Limite(new Float(campos[INDEX_VALUE]), campos[INDEX_TIPO_VEHICULO],  campos[INDEX_CLIMA]); 
					System.out.println(limite);
					//TODO PERSISTIR LIMITE
					
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}