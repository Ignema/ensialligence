package com.ensialligence.web.rest;

import com.ensialligence.model.Friend;
import com.ensialligence.service.FriendService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
public class FriendResource {

    FriendService friend = new FriendService();

    @POST
    @Path("/friends")
    //@Consumes(MediaType.APPLICATION_JSON)
    public Friend addFriend(Friend f) {
        return friend.addFriend(f);
    }

    @DELETE
    @Path("/friends/{idFriend}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_JSON})
    public void deleteFriend(@PathParam(value="idFriend")int idFriend) {
        friend.deleteFriend(idFriend);
    }

    @GET
    @Path("/user/{idUser}/friends")
    public List<Friend> friendsByIdUser(@PathParam (value="idUser")int idUser){
        return friend.getFriends(idUser);

    }

}