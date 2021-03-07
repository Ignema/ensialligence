package com.ensialligence.UnitTest;


import com.ensialligence.model.Article;
import com.ensialligence.service.ArticleService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleTest {

    ArticleService articleService = new ArticleService();

    static List<Article> articles;
    static Article article ;
    @BeforeClass
    public static void init(){
         articles = new ArrayList<>();
         article = new Article();
    }
    @After
    public  void print(){
        for(Article a : articles) {

            System.out.println("Article [idarticle=" + a.getIdarticle() + ", id=" + a.getId() + ", titre=" + a.getTitre() + ", categorie=" + a.getCategorie()
                    + ", image=" + a.getImage() + ", video=" + a.getVideo() + ", nbjaimeart=" + a.getNbjaimeart() + "]");

        }
    }



    //************* Tester la method save ************//
    @Test
    public void testSave() {

        File img = new File("C:/Users/Lenovo\\Desktop/MyworkSpace/ProjetSIAPP/memories.png");
        Article article = articleService.save(2,"Devellopemt WEB","JEE",img,null,20);
        System.out.println("Article [idarticle=" + article.getIdarticle() + ", id=" + article.getId() + ", titre=" + article.getTitre() + ", categorie=" + article.getCategorie()
                + ", image=" + article.getImage() + ", video=" + article.getVideo() + ", nbjaimeart=" + article.getNbjaimeart() + "]");


        //assertEquals("The article was succesfuly saved !!",rslt);
    }
    //**************************************************//

    //*********** Tester la method getAricles*********//
    @Test
    public void testGetAricles() {
        articles = articleService.getAricles();
        System.out.println(" les articles : ");
    }
    //**********************************************//

    //********Tester le method ChercheParTitre*********//
    @Test
    public void testChercheParTitre() {
        articles = articleService.chercheParTitre("Massa");
        assertEquals(2,articles.size());
        System.out.println(" les articles par Titre 'Massa' : ");
    }
    //**********************************************//


    //********Tester le method ChercheParCategorie*********//
    @Test
    public void testChercheParCategorie() {
        articles = articleService.chercheParCategorie("Dic");
        assertEquals(1,articles.size());
        System.out.println(" les articles par Categorie 'Dic' : ");
    }
    //*********************************************//

    //********Tester le method ChercheParCategorie*********//
    @Test
    public void testUpdated() {
        Article article = new Article();
        article.setTitre("hello Word !!");
        System.out.println(articleService.updateArticle(70,article));
        //assertEquals("the Article was update succesufully",articleService.updateArticle(70,article));
    }
    //******************************************************//

    //********Tester le method ChercheParCategorie*********//
    @Test
    public void testdelete() {
        assertEquals("The article was successfuly deleted !",articleService.deleteArticle(45));
    }
    //******************************************************//


}
