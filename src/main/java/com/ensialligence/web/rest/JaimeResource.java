package com.ensialligence.web.rest;

import com.ensialligence.model.Jaime;
import com.ensialligence.service.JaimeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
public class JaimeResource {
	
	JaimeService jaime = new JaimeService();

	@POST
	@Path("/jaime")
	//@Consumes(MediaType.APPLICATION_JSON)
	public Jaime addJaime(Jaime j) {
		return jaime.addJaime(j);
	}
	
	/*@DELETE
	@Path("/jaime")
	public void deleteJaime(Jaime j) {
		jaime.removeJaime(j);
	}*/

}
