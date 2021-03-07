package com.ensialligence.IntegrationTest;


import com.ensialligence.model.Commentaire;
import com.ensialligence.model.Friend;
import com.ensialligence.model.Jaime;
import org.json.JSONArray;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class IntegerationApiTest {

    static String url;
    static JSONArray jsonArray;
    static boolean cle ;
    static int idUser;
    @BeforeClass
    public static void init(){

        url="";
        cle = false;
        idUser=2;
    }
    @After
    public  void result() {
        //assumeTrue(IntegerationApiTest.getMethodName().equals("myMethodName"));
        //assumeTrue(IntegerationApiTest.class.getEnclosingMethod().getName(), equals("TestApiGetArticle"));
        //assumeTrue(IntegerationApiTest.class.getEnclosingMethod().getName(), equals("TestApichercheParCategorie"));
        if ( cle ) {


        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(url);
        Response res = target
                .request(MediaType.APPLICATION_JSON)
                .get();
        String json = res.readEntity(String.class);
        jsonArray = new JSONArray(json);
        System.out.println(jsonArray);
        }else {

        }

    }
    @AfterAll
    public static void  close(){
        //res.close();
    }



    //*************l'utilisateur veut visualiser l'ensemble des articles**********//
    @Test
    public void TestApiGetArticle(){
        cle =true;
        url = "http://localhost:8080/Ensialligence_war/api/v1/arts";
    }

    //***********l'utilisateur veut chercher l'ensemble des article par categorie //
    @Test
    public void TestApichercheParCategorie(){
        cle =true;
        url = "http://localhost:8080/Ensialligence_war/api/v1/chercheParCategorie?categorie=Quis Consectetur Mi";
    }


    //************l'utiisateur a aime une article **********************//
    @Test
    public void TestApiAddJaime(){
        cle =false;
        Client clienT = ClientBuilder.newClient();
        url="http://localhost:8080/Ensialligence_war/api/v1/jaime";
        WebTarget targeT = clienT.target(url);
        Jaime jaime = new Jaime(2, 26);
        Response reS = targeT
                .request(MediaType.APPLICATION_JSON)
                .accept("Content-Type",MediaType.TEXT_PLAIN)
                .post(Entity.json(jaime));
        String result = reS.readEntity(String.class);
        System.out.println(result);
    }
    //***********l'utilisateur veut ajoutez son commentaire******************//
    @Test
    public void TestApiAddCom() {
        cle = false;
        Client clienT = ClientBuilder.newClient();
        url = "http://localhost:8080/Ensialligence_war/api/v1/comments";
        WebTarget targeT = clienT.target(url);
        Commentaire commentaire = new Commentaire(1, 6,13," add a comment", 12);
        Response reS = targeT
                .request(MediaType.APPLICATION_JSON)
                .accept("Content-Type", MediaType.TEXT_PLAIN)
                .post(Entity.json(commentaire));
        String result = reS.readEntity(String.class);
        System.out.println(result);
    }
    //***********l'utilisateur veut Modifier son commentaire ***********//
    @Test
    public void TestApiUpdateCom(){
        Client client = ClientBuilder.newClient();
        url="http://localhost:8080/Ensialligence_war/api/v1/comments";
        WebTarget target = client.target(url);
        Commentaire commentaire = new Commentaire(1, 6,13," add a comment", 12);
        commentaire.setComment("ça arrive mais pas tout temps , Faut pas generaliser !");
        Response res = target
                .request(MediaType.APPLICATION_JSON)
                .accept("Content-Type",MediaType.TEXT_PLAIN)
                .put(Entity.json(commentaire));
        String result = res.readEntity(String.class);
        System.out.println(result);
    }
    //************l'utilisateur veut supprimer son commentaire *********************//
    @Test
    public void TestApiDeleteCom(){
        Client client = ClientBuilder.newBuilder().build();
        url="http://localhost:8080/Ensialligence_war/api/v1/comments/1";
        WebTarget target = client.target(url);
        Response res = target
                .request()
                .delete();

        String result = res.readEntity(String.class);
        res.close();
    }
    //**********l'utilisateur veut ajouter un ami *******************//
    @Test
    public void TestApiAddFriend() {
        cle = false;
        Client clienT = ClientBuilder.newClient();
        url = "http://localhost:8080/Ensialligence_war/api/v1/friends";
        WebTarget targeT = clienT.target(url);
        Friend friend = new Friend(idUser, 3);
        Response reS = targeT
                .request(MediaType.APPLICATION_JSON)
                .accept("Content-Type", MediaType.TEXT_PLAIN)
                .post(Entity.json(friend));
        String result = reS.readEntity(String.class);
        System.out.println(result);
    }
}
