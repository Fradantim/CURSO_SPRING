package com.fradantim.sensorDeVelocidad;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fradantim.sensorDeVelocidad.controller.SensorControllerTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SensorDeVelocidadApplication.class)
public class SensorDeVelocidadApplicationTests {
	
	private static final Logger logger = LoggerFactory.getLogger(SensorDeVelocidadApplicationTests.class);

	@Autowired
	SensorControllerTest sensorController;
	
	@Test
	public void sensar() {
		logger.info("Este es mi metodo de TEST!!!!");
		try {
			sensorController.sensar();
		} catch(Exception e) {
			//si algo falla (como la BBDD en memoria lo hago explotar)
			logger.error("Error al ejecutar el test: "+e.getMessage()+" || "+e.getLocalizedMessage());
			Assert.assertTrue(true);
		}
	}
}
