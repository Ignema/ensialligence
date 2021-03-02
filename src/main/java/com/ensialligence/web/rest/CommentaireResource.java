package com.ensialligence.web.rest;

import com.ensialligence.model.Commentaire;
import com.ensialligence.service.CommentaireService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/")
@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
public class CommentaireResource {

    CommentaireService com = new CommentaireService();

    @GET
    @Path("/articles/{idArticle}/comments")
    public List<Commentaire> comsByArticle(@PathParam (value="idArticle")int idArticle){
        return com.getComments(idArticle);

    }

    @GET
    @Path("/comments/{idCom}")
    public Commentaire comById(@PathParam (value="idCom")int idCom){
        return com.getCommentById(idCom);

    }

    @POST
    @Path("/comments")
    //@Consumes(MediaType.APPLICATION_JSON)
    public Commentaire addCom(Commentaire c) {
        return com.addComment(c);
    }

    @DELETE
    @Path("/comments/{idCom}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_JSON})
    public void deleteCom(@PathParam(value="idCom")int idCom) {
        com.deleteComment(idCom);
    }

    @PUT
    @Path("/comments")
    public Commentaire updateCom(Commentaire c) {
        return com.updateComment(c);
    }



}