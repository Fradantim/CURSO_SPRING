package com.fradantim.sensorDeVelocidad.persistence.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sensorvelocidad.DatosVehiculo;

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
	private Integer value; 
	
	@Column (name= "TIPO_VEHICULO")
	private String tipoVehiculo;
	
	@Column (name= "TIPO_CLIMA")
	private String tipoClima;

	public Limite() {}
	
	public Limite(Integer value, String tipoVehiculo, String tipoClima) {
		this.value = value;
		this.tipoVehiculo = tipoVehiculo;
		this.tipoClima = tipoClima;
	}

	public boolean superaLimite(DatosVehiculo datos) {
		return datos.velocidadMedida > value;
	}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getTipoClima() {
		return tipoClima;
	}

	public void setTipoClima(String tipoClima) {
		this.tipoClima = tipoClima;
	}
	
	
}
