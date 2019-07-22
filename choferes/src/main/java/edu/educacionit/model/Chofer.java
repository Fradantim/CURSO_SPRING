package edu.educacionit.model;

import java.util.UUID;

import com.google.gson.Gson;

public class Chofer {
	private UUID uuid;
	private String nombre;
	private String apellido;
	private Boolean leGustaSuTrabajo;
	private Integer cantAccidentes;
	
	public Chofer(UUID uuid, String nombre, String apellido, Boolean leGustaSuTrabajo, Integer cantAccidentes) {
		this.uuid = uuid;
		this.nombre = nombre;
		this.apellido = apellido;
		this.leGustaSuTrabajo = leGustaSuTrabajo;
		this.cantAccidentes = cantAccidentes;
	}
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
	public Chofer () {}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Boolean getLeGustaSuTrabajo() {
		return leGustaSuTrabajo;
	}

	public void setLeGustaSuTrabajo(Boolean leGustaSuTrabajo) {
		this.leGustaSuTrabajo = leGustaSuTrabajo;
	}

	public Integer getCantAccidentes() {
		return cantAccidentes;
	}

	public void setCantAccidentes(Integer cantAccidentes) {
		this.cantAccidentes = cantAccidentes;
	}
	
}
