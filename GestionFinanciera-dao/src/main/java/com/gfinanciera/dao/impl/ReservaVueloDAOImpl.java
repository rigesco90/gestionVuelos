package com.gfinanciera.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gfinanciera.dao.ReservaVueloDAO;
import com.gfinanciera.entidades.Vuelo;

public class ReservaVueloDAOImpl implements ReservaVueloDAO {

	@PersistenceContext(unitName = "GestionVuelosPU")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Vuelo> listaVuelos() {
		return em.createQuery("SELECT v FROM Vuelo v " 
							+ "JOIN FETCH v.aerolina a "
							+ "JOIN FETCH v.cliente c "
							+ "JOIN FETCH v.estado e "
							+ "JOIN FETCH v.origen o "
							+ "JOIN FETCH v.destino d").getResultList();
	}

}
