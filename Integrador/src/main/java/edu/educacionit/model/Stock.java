package edu.educacionit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue
    private Long id;
    private String nombre;
    private String marca;
    private String sector;
    private String peso;
    private Integer unidades;
	
    public Stock() {}
    
    public Stock(String nombre, String marca, String sector, String peso, Integer unidades) {
    	this(null, nombre, marca, sector, peso, unidades);
    }
    
    public Stock modify(Stock s) {
    	return modify(s.getNombre(), s.getMarca(), s.getSector(), s.getPeso(), s.getUnidades());
    }
    
    public Stock modify(String nombre, String marca, String sector, String peso, Integer unidades) {
		this.nombre = nombre;
		this.marca = marca;
		this.sector = sector;
		this.peso = peso;
		this.unidades = unidades;
		
		return this;
	}
    
    public Stock(Long id, String nombre, String marca, String sector, String peso, Integer unidades) {
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.sector = sector;
		this.peso = peso;
		this.unidades = unidades;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}    
}
