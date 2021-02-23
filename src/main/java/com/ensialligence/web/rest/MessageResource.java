package com.ensialligence.web.rest;

import com.ensialligence.model.Message;
import com.ensialligence.service.MessageService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
public class MessageResource {
	
	MessageService msg = new MessageService();
	
	@POST
	@Path("/msgs")
	//@Consumes(MediaType.APPLICATION_JSON)
	public Message addMsg(Message m) {
		return msg.saveMsg(m);
	}
	
	@DELETE
	@Path("/msgs")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_JSON})
	public void deleteMsg(@FormParam(value="idMsg")int idMsg) {
		msg.deleteMsg(idMsg);
	}

}
