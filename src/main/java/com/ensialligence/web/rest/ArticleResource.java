package com.ensialligence.web.rest;

import com.ensialligence.model.Article;
import com.ensialligence.service.ArticleService;
//import com.sun.jersey.multipart.FormDataBodyPart;
//import com.sun.jersey.multipart.FormDataMultiPart;
//import com.sun.jersey.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.*;

import javax.servlet.*;
import javax.servlet.http.*;
//import javax.servlet.annotation.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Path("/")
public class ArticleResource extends HttpServlet {


    ArticleService articleService = new ArticleService();

    @GET
    @Path("/y")
    public String gethello() {
        return "home";
    }
    @GET
    @Path("/arts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> gets() {
        List<Article> arts = articleService.getAricles();
        return arts;
    }

    @GET
    @Path("/chercherTitre")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> chercherTitre(@QueryParam("titre") String titre) {
        List<Article> arts =articleService.chercheParTitre(titre);
        for(Article a : arts) {
            System.out.println( "Article [idarticle=" + a.getIdarticle() + ", titre=" + a.getTitre() + ", categorie=" +a.getCategorie()+"]");
        }
        return arts;
    }
    @GET
    @Path("/chercheParCategorie")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> chercheParCategorie(@QueryParam("categorie") String categorie) {
        List<Article> arts =articleService.chercheParCategorie(categorie);
        for(Article a : arts) {
            System.out.println( "Article [idarticle=" + a.getIdarticle() + ", titre=" + a.getTitre() + ", categorie=" +a.getCategorie()+"]");
        }
        return arts;
    }

    @GET
    @Path("deleteArticle/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteArticle(@PathParam("id") int id) {
        return articleService.deleteArticle(id);
    }

    @PUT
    @Path("update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //@Consumes("application/x-www-form-urlencoded")
    public Article updateArticle(
            @PathParam("id") int id,
            Article article ) {

        return articleService.updateArticle(id,article);
    }

    static File img ;
    @POST
    @Path("/savefile")
    //@Consumes(MediaType.MULTIPART_FORM_DATA)
    @Consumes({"application/x-www-from-urlencoded",MediaType.MULTIPART_FORM_DATA,MediaType.APPLICATION_JSON})
    public void create (@FormDataParam("file") File image){
        img = image;
        //articleService.save(2,"TST","TST",img,null,12);
    }
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Article  create (Article article){

        System.out.println( "Article [idarticle=" + article.getIdarticle() + ", titre=" + article.getTitre() + ", categorie=" +article.getCategorie()+"]");
         articleService.save(article.getId(),article.getTitre(),article.getCategorie(),img,null,article.getNbjaimeart());
        List<Article> art = articleService.getAricles();
        article.setIdarticle(art.get(art.size()-1).getIdarticle());
        return article;
    }


/*
    @POST
    @Path("/sendemail")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sendEmail(Article article) {
        System.out.println( article.getTitre());
        return Response.ok("name=" + article.getTitre()).build();
    }*/
/*
    @POST
    @Path("/test")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public void provideService(@FormDataParam("email") String email,@FormDataParam("name") String name){
      //FormDataBodyPart file = from.getField("file");@FormDataParam("file") File image ,
        //FormDataMultiPart from,@FormDataParam("file") File image,
        System.out.println(name + email );

    }*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().write("hello world !!");

        response.getWriter().append("Served at: ").append(request.getContextPath());
        System.out.print(request.getContextPath());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
