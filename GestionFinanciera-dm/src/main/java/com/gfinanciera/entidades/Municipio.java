package com.gfinanciera.entidades;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmunicipio;

	private String codigo;

	private String descripcion;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JsonManagedReference
	private Departamento departamento;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="origen")
	@JsonBackReference
	private List<Vuelo> vuelos1;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="destino")
	@JsonBackReference
	private List<Vuelo> vuelos2;

	public Municipio() {
	}

	public int getIdmunicipio() {
		return this.idmunicipio;
	}

	public void setIdmunicipio(int idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Vuelo> getVuelos1() {
		return this.vuelos1;
	}

	public void setVuelos1(List<Vuelo> vuelos1) {
		this.vuelos1 = vuelos1;
	}

	
	public List<Vuelo> getVuelos2() {
		return this.vuelos2;
	}

	public void setVuelos2(List<Vuelo> vuelos2) {
		this.vuelos2 = vuelos2;
	}

}