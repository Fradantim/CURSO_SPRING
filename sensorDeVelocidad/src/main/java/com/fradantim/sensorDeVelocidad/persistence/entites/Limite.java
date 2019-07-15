package com.fradantim.sensorDeVelocidad.persistence.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "LIMITE")
public class Limite extends AbsEntity{

	/*
	public enum TipoVehiculo{
		AUTO, MOTO, CAMION, TRACTOR;
	}
	
	public enum TipoClima{
		NORMAL, LLUVIA_MODERADA, LLUVIA_TORRENCIAL;
	}*/
	
	@Column (name= "VALUE")
	private Float value; 
	
	@Enumerated
	@Column (name= "TIPO_VEHICULO")
	private String tipoVehiculo;
	
	@Enumerated
	@Column (name= "TIPO_CLIMA")
	private String tipoClima;

	public Limite(Float value, String tipoVehiculo, String tipoClima) {
		this.value = value;
		this.tipoVehiculo = tipoVehiculo;
		this.tipoClima = tipoClima;
	}
}
