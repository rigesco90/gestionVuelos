package com.gfinanciera.BOImplements;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gfinanciera.BO.ReservaVueloBO;
import com.gfinanciera.dao.ReservaVueloDAO;
import com.gfinanciera.entidades.Vuelo;

@Stateless
public class ReservaVueloEJB implements ReservaVueloBO {

	@Inject
	ReservaVueloDAO resevaDAO;

	@Override
	public String listaVuelos() {
		String vuelos = null;
		List<Vuelo> listClientes = new ArrayList<Vuelo>();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {			
			listClientes = resevaDAO.listaVuelos();
			if (listClientes != null && listClientes.size() > 0) {
				vuelos = objectMapper.writeValueAsString(listClientes);
			}
		} catch (Exception e) {
			System.out.println("ERROR::: " + e.getMessage());
		}
		return vuelos;
	}

}
