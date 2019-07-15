package com.fradantim.sensorDeVelocidad.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fradantim.sensorDeVelocidad.persistence.entites.Limite;
import com.fradantim.sensorDeVelocidad.persistence.repository.LimiteRepository;

@Service
public class LimiteService {
	
	@Autowired
	private LimiteRepository limiteRepo;

	public Limite save(Limite limite) {
		return limiteRepo.save(limite);
	}
	
	public Limite findByTipoVehiculoAndTipoClima(String tipoVehiculo, String tipoClima) {
		return limiteRepo.findByTipoVehiculoIgnoreCaseAndTipoClima(tipoVehiculo, tipoClima);
	}
	
	public Integer getCount() {
		return limiteRepo.findAll().size();
	}
}
