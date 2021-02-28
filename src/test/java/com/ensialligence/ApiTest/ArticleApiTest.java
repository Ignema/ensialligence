package com.ensialligence.ApiTest;

import com.ensialligence.model.Article;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



public class ArticleApiTest {


    @Test
    public void TestApiGetArticle(){
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://localhost:8080/Ensialligence_war/api/v1/arts");
        Response res = target
                .request(MediaType.APPLICATION_JSON)
                .get();
        String json = res.readEntity(String.class);
        JSONArray jsonArray = new JSONArray(json);
        JSONObject jsonO = (JSONObject) jsonArray.get(0);
        //System.out.println(jsonArray.length());
        res.close();
        assertEquals(18,jsonArray.length());
        assertEquals("Imperdiet Ex Etiam Cursus",jsonO.get("categorie"));

    }

    @Test
    public void TestApichercherTitre(){
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://localhost:8080/Ensialligence_war/api/v1/chercherTitre?titre=Massa");
        Response res = target
                .request(MediaType.APPLICATION_JSON)
                .get();
        String json = res.readEntity(String.class);
        JSONArray jsonArray = new JSONArray(json);
        JSONObject jsonO = (JSONObject) jsonArray.get(0);
        System.out.println(jsonO.get("titre"));
        res.close();
        assertEquals("Massa  Id",jsonO.get("titre"));

    }
    @Test
    public void TestApichercheParCategorie(){
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://localhost:8080/Ensialligence_war/api/v1/chercheParCategorie?categorie=Quis Consectetur Mi");
        Response res = target
                .request(MediaType.APPLICATION_JSON)
                .get();
        String json = res.readEntity(String.class);
        JSONArray jsonArray = new JSONArray(json);
        JSONObject jsonO = (JSONObject) jsonArray.get(0);
        //System.out.println(jsonO.get("titre"));
        res.close();
        assertEquals("Quis Consectetur Mi Venenatis",jsonO.get("categorie"));

    }
    @Test
    public void TestApiUpdate(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/Ensialligence_war/api/v1/update/285");
        Article art =new Article();
        art.setTitre("i am being updated !");
        art.setCategorie("i am being updated !");
        Response res = target
                .request(MediaType.APPLICATION_JSON)
                .accept("Content-Type",MediaType.TEXT_PLAIN)
               // .header("Content-Type",MediaType.TEXT_PLAIN)
                .put(Entity.json(art));
        String result = res.readEntity(String.class);
        //System.out.println(result);
        assertEquals("the Article was update succesufully",result);
        }

    @Test
    public void TestApiSave(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/Ensialligence_war/api/v1/save");
        Article art =new Article();
        art.setIdarticle(22);
        art.setId(16);
        art.setTitre("i am being saved !");
        art.setCategorie("i am being saved !");
        art.setImage(null);
        art.setVideo(null);
        art.setNbjaimeart(15);
        Response res = target
                .request(MediaType.APPLICATION_JSON)
                .accept("Content-Type",MediaType.TEXT_PLAIN)
                // .header("Content-Type",MediaType.TEXT_PLAIN)
                .post(Entity.json(art));
        String result = res.readEntity(String.class);
        //System.out.println(result);
        assertEquals("Succesfully saved !",result);
    }

    @Test
    public void TestApiDelete(){
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://localhost:8080/Ensialligence_war/api/v1/deleteArticle/286");
        Response res = target
                .request()
                .get();

        String result = res.readEntity(String.class);

        //System.out.println(result);
        res.close();
        assertEquals("The article was successfuly deleted !",result);
    }


}
