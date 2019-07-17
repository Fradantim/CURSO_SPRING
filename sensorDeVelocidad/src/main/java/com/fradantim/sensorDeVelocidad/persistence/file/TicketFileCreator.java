package com.fradantim.sensorDeVelocidad.persistence.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fradantim.sensorDeVelocidad.persistence.dao.TicketDao;
import com.fradantim.sensorDeVelocidad.persistence.entites.Ticket;
import com.google.gson.Gson;

@Component(value="TicketFileCreator")
public class TicketFileCreator implements TicketDao {

	private static final Logger logger = LoggerFactory.getLogger(TicketFileCreator.class);
	
	private static final Gson GSON = new Gson();
	
	public static final String PATH = "/SensorDeVelocidad";
	
	public static final File FILE_PATH = new File(PATH);
	
	@Override
	public Ticket save(Ticket ticket) {
		createPathIfNotExist();
		writeToFile(ticket);
		return ticket;
	}
	
	private void createPathIfNotExist() {
		logger.debug("Verifico si existe '"+ FILE_PATH+"'");
		if(!FILE_PATH.exists() || !FILE_PATH.isDirectory()) {
			logger.debug("No existe '"+ FILE_PATH+"'"+" lo creo.");
			 if(!FILE_PATH.mkdir()) {
				 logger.error("No pudo crearse la ruta '"+ FILE_PATH+"'");
			 }
		}
	}
	
	private void writeToFile(Ticket ticket) {
		String jsonString = GSON.toJson(ticket);
		String file=FILE_PATH.getAbsolutePath()+"/"+ticket.getId()+".txt";
		logger.debug("Escribo archivo "+file);
		try (FileWriter fw = new FileWriter(file);) {
			fw.write(jsonString);    
		    fw.close();
		} catch (IOException e) {
			logger.error("Error al trabajar con el archivo '"+file+"' "
					+e.getMessage()+" || "+e.getLocalizedMessage());
		}    
           
	}
	
}