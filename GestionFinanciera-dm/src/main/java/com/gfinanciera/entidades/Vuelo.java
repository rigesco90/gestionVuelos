package com.gfinanciera.entidades;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Timestamp;

/**
 * The persistent class for the vuelo database table.
 * 
 */
@Entity
@NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v")
public class Vuelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvuelo;

	@Column(name = "FECHA_LLEGADA")
	private Timestamp fechaLlegada;

	@Column(name = "FECHA_SALIDA")
	private Timestamp fechaSalida;

	private double valor;

	// bi-directional many-to-one association to Aerolina
	@ManyToOne
	private Aerolina aerolina;

	// bi-directional many-to-one association to Cliente
	@ManyToOne
	@JsonManagedReference
	private Cliente cliente;

	// bi-directional many-to-one association to Estado
	@ManyToOne
	@JsonManagedReference
	private Estado estado;

	// bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name = "municipio_idmunicipio_origen")
	@JsonManagedReference
	private Municipio origen;

	// bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name = "municipio_idmunicipio_destino")
	@JsonManagedReference
	private Municipio destino;

	public Vuelo() {
	}

	public int getIdvuelo() {
		return this.idvuelo;
	}

	public void setIdvuelo(int idvuelo) {
		this.idvuelo = idvuelo;
	}

	public Timestamp getFechaLlegada() {
		return this.fechaLlegada;
	}

	public void setFechaLlegada(Timestamp fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Timestamp getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Aerolina getAerolina() {
		return this.aerolina;
	}

	public void setAerolina(Aerolina aerolina) {
		this.aerolina = aerolina;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Municipio getDestino() {
		return destino;
	}

	public void setDestino(Municipio destino) {
		this.destino = destino;
	}

	public Municipio getOrigen() {
		return origen;
	}

	public void setOrigen(Municipio origen) {
		this.origen = origen;
	}

}