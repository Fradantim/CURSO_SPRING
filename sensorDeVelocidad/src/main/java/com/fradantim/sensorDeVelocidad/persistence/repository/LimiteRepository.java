package com.fradantim.sensorDeVelocidad.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fradantim.sensorDeVelocidad.persistence.entites.Limite;

@Repository
public interface LimiteRepository extends JpaRepository<Limite, Integer> {

	public Limite findByTipoVehiculoIgnoreCaseAndTipoClima(String tipoVehiculo, String tipoClima);
}