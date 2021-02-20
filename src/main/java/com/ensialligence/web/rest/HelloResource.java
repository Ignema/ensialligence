package com.ensialligence.web.rest;

import com.ensialligence.domain.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethode() {
        return "Hello World";
    }

    @GET
    @Path("/user/1")
    @Produces("application/json")
    public User getUser() {
        return new User(1L, "mohammed", "123456");
    }

    @GET
    @Path("/users")
    @Produces("application/json")
    public ArrayList<User> getListUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1L,"med","edd"));
        users.add(new User(2L,"yas","dous"));
        return users;
    }
}