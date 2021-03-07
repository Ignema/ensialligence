package com.ensialligence.IntegrationTest;

import com.ensialligence.model.*;
import com.ensialligence.service.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IntegrationTest {



    ArticleService articleService = new ArticleService();
    JaimeService jaime = new JaimeService();
    CommentaireService com = new CommentaireService();
    FriendService friend = new FriendService();

    static List<Article> articles,articleParCat;
    static Commentaire commentaire;
    static  UserService userService;


    @BeforeAll
    public static void iniit(){
        System.out.println("BeforeAll init() method called");
    }

    @BeforeClass
    public static void init(){
        articles = new ArrayList<>();
        articleParCat = new ArrayList<>();
        commentaire = new Commentaire();
        userService=new UserService();
        System.out.println("before class ....");

    }
    @AfterClass
    public static void suivant(){
        System.out.println("after  class ....");
        for(Article a : articles) {

            System.out.println("Article [idarticle=" + a.getIdarticle() + ", id=" + a.getId() + ", titre=" + a.getTitre() + ", categorie=" + a.getCategorie()
                    + ", image=" + a.getImage() + ", video=" + a.getVideo() + ", nbjaimeart=" + a.getNbjaimeart() + "]");

        }
        System.out.println("...............................");
        for(Article a : articleParCat) {

            System.out.println("Article [idarticle=" + a.getIdarticle() + ", id=" + a.getId() + ", titre=" + a.getTitre() + ", categorie=" + a.getCategorie()
                    + ", image=" + a.getImage() + ", video=" + a.getVideo() + ", nbjaimeart=" + a.getNbjaimeart() + "]");

        }
        System.out.println("...............................");
            System.out.println("this Commentaire was add : Commentaire [idCom=" + commentaire.getIdCom() + ", idUser=" + commentaire.getIdUser() + ", idArticle=" + commentaire.getIdArticle() + ", comment="
                + commentaire.getComment() + ", nbJaimeCom=" + commentaire.getNbJaimeCom() + "]");

    }

    @Test
    public void main(){
        System.out.println("Test Class .... ");
        //**************On va commencer Par creer un Compte dans l'application **************//
        long idUser = 2L ;
        userService.addUser(new User(idUser, "med", "123","med", "edd", "med@gmail.com", "2010-04-02"));

        //*************l'utilisateur veut visualiser l'ensemble des articles**********//
         articles = articleService.getAricles();

        //***********l'utilisateur veut chercher l'ensemble des article par categorie //

        String Mot_cle ="Lectus";
        articleParCat = articleService.chercheParCategorie(Mot_cle);

        //************l'utiisateur a aime une article **********************//
        jaime.addJaime(new Jaime((int)idUser, 26));

        //***********l'utilisateur veut ajoutez son commentaire******************//
        Commentaire c = new Commentaire(1, (int)idUser,26,"c pas vrai !!! ", 0);
        commentaire =com.addComment(c);
        //***********l'utilisateur veut Modifier son commentaire ***********//
        c.setComment("ça arrive mais pas tout temps , Faut pas generaliser !");
        com.updateComment(c);

        //*********l'utilisateur veut Ajouter une Article*************************//
        File img = new File("C:/Users/Lenovo\\Desktop/MyworkSpace/ProjetSIAPP/memories.png");
        articleService.save((int)idUser,"Devellopemt WEB","JEE",img,null,20);

        //************l'utilisateur veut supprimer son commentaire *********************//
        com.deleteComment(1);

        //**********l'utilisateur veut ajouter un ami *******************//
        friend.addFriend(new Friend((int)idUser, 3));

    }
}
