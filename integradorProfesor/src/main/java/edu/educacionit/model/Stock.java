package edu.educacionit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="marca")
    private String marca;
    @Column(name="sector")
    private String sector;
    @Column(name="peso")
    private String peso;
    @Column(name="unidades")
    private Integer unidades;

    public Stock() {
    }
    
    public Stock(String id, String marca, String sector, Integer unidades) {
        this.id = id;
        this.marca = marca;
        this.sector = sector;
        this.unidades = unidades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
