package com.gfinanciera.WSclientes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gfinanciera.BO.ReservaVueloBO;

@Stateless
@Path("WSRestReservas")
public class WSRestReservas {

	@EJB
	private transient ReservaVueloBO reservaBO;

	@GET
	@Path("/listReservas")
	@Produces(MediaType.APPLICATION_JSON)	
	public String listClients() throws Exception {

		return reservaBO.listaVuelos();

	}

}
