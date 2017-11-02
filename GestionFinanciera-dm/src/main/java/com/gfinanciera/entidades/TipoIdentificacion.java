package com.gfinanciera.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_identificacion database table.
 * 
 */
@Entity
@Table(name="tipo_identificacion")
@NamedQuery(name="TipoIdentificacion.findAll", query="SELECT t FROM TipoIdentificacion t")
public class TipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTIPO_IDENTIFICACION;

	private String codigo;

	private String descripcion;

	public TipoIdentificacion() {
	}

	public int getIdTIPO_IDENTIFICACION() {
		return this.idTIPO_IDENTIFICACION;
	}

	public void setIdTIPO_IDENTIFICACION(int idTIPO_IDENTIFICACION) {
		this.idTIPO_IDENTIFICACION = idTIPO_IDENTIFICACION;
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

}