package com.ensialligence.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("gg")
public class MyResources {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethode() {
        return "it's good";
    }

}