package com.fradantim.sensorDeVelocidad.persistence.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class Ticket extends AbsEntity{
	
	@Column (name= "PATENTE")
	private String patente;
	
	@Column (name= "VELOCIDAD")
	private Integer velocidad;
	
	@Column (name= "TIPO_VEHICULO")
	private String tipoVehiculo;
	
	@ManyToOne
	@JoinColumn(name="LIMITE_ID")
	private Limite limite;

	public Ticket(String patente, Integer velocidad, String tipoVehiculo, Limite limite) {
		this.patente = patente;
		this.velocidad = velocidad;
		this.tipoVehiculo = tipoVehiculo;
		this.limite = limite;
	}
	
	public Ticket() { }

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Integer getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Limite getLimite() {
		return limite;
	}

	public void setLimite(Limite limite) {
		this.limite = limite;
	}
}
