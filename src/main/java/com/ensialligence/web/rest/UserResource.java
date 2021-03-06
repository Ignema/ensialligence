package com.ensialligence.web.rest;

import com.ensialligence.config.PersistenceConfig;
import com.ensialligence.model.User;
import com.ensialligence.service.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	UserService userService=new UserService();
    
    @GET
    @Path("/user")
    @Produces("application/json")
    public User getUser(@QueryParam(value="username") String username,@QueryParam(value="password") String password) {
        return userService.findUser(username, password);
    }
    
    @GET
    @Path("/listFriends")
    @Produces("application/json")
    public ArrayList<User> getListFriends(@QueryParam(value="id") Long id) {
    	System.out.println(id);
        return userService.listFriends(id);
    }

    @POST
    @Path("/addUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({"application/x-www-form-urlencoded","multipart/form-data",MediaType.APPLICATION_JSON})
    public String addUser(@FormParam("username") String username,
    					   @FormParam("password") String password,
    					   @FormParam("firstname") String firstname,
    					   @FormParam("lastname")String lastname,
    					   @FormParam("email") String email,
    					   @FormParam("date_nais") String date_nais) {
    	return userService.addUser(new User(username,password,firstname,lastname,email,date_nais));
    }
    
}