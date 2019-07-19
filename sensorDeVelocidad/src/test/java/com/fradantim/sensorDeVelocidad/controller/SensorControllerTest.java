package com.fradantim.sensorDeVelocidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SensorControllerTest extends SensorController{
	
	/* uso injeccion en constructor para que la clase main instancie 
	 * la implementacion concreta, y que la clase test instancie
	 *  la implementacion mock
	 */
	@Autowired
	public SensorControllerTest(TicketControllerMock ticketController) {
		super(ticketController);
	}
		
}
