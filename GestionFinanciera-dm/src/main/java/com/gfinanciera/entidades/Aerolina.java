package com.gfinanciera.entidades;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the aerolina database table.
 * 
 */
@Entity
@NamedQuery(name="Aerolina.findAll", query="SELECT a FROM Aerolina a")
public class Aerolina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAerolina;

	private String codigo;

	private String nombre;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="aerolina")
	@JsonBackReference
	private List<Vuelo> vuelos;

	public Aerolina() {
	}

	public int getIdAerolina() {
		return this.idAerolina;
	}

	public void setIdAerolina(int idAerolina) {
		this.idAerolina = idAerolina;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Vuelo> getVuelos() {
		return this.vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public Vuelo addVuelo(Vuelo vuelo) {
		getVuelos().add(vuelo);
		vuelo.setAerolina(this);

		return vuelo;
	}

	public Vuelo removeVuelo(Vuelo vuelo) {
		getVuelos().remove(vuelo);
		vuelo.setAerolina(null);

		return vuelo;
	}

}