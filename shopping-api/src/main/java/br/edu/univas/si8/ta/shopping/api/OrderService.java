package br.edu.univas.si8.ta.shopping.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/order")
public interface OrderService {
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	String[] listPedidos();

	@POST
	@Path("/add/{pedido}")
	@Produces(MediaType.APPLICATION_JSON)
	String saveNewPedido(@PathParam("description") String description);

}
