package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/estadisticasJbici/{entidad}")
public class EstadisticasResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	EstadisticasServices estadisticasService;
	
	public EstadisticasResource() {
		estadisticasService = new EstadisticasServices();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON )
	public List<EstadisticaOperacion> getEstadisticaOperacion(@PathParam("entidad") String entidad) {
		return estadisticasService.getEstadisticaOperacion(entidad);
	}
}