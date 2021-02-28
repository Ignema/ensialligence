package com.ensialligence.UnitTest;


import com.ensialligence.model.Article;
import com.ensialligence.service.ArticleService;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArticleTest {

    ArticleService articleService = new ArticleService();

    List<Article> articles;
    Article article ;
    @BeforeAll
    public void init(){
         articles = new ArrayList<>();
         article = new Article();
    }
    @AfterEach
    public void rslt(){
        for(Article a : articles) {

            System.out.println("Article [idarticle=" + a.getIdarticle() + ", id=" + a.getId() + ", titre=" + a.getTitre() + ", categorie=" + a.getCategorie()
                    + ", image=" + a.getImage() + ", video=" + a.getVideo() + ", nbjaimeart=" + a.getNbjaimeart() + "]");

        }
    }
    @AfterAll
    public static void print(){
        System.out.println("cleaning up ...");
    }


    //************* Tester la method save ************//
    @Test
    public void testSave() {

        File img = new File("C:/Users/Lenovo\\Desktop/MyworkSpace/ProjetSIAPP/memories.png");
        articleService.save(2,"Devellopemt WEB","JEE",img,null,20);
    }
    //**************************************************//

    //*********** Tester la method getAricles*********//
    @Test
    public void testGetAricles() {
        articles = articleService.getAricles();
    }
    //**********************************************//

    //********Tester le method ChercheParTitre*********//
    @Test
    public void testChercheParTitre() {
        articles = articleService.chercheParTitre("Massa");
    }
    //**********************************************//


    //********Tester le method ChercheParCategorie*********//
    @Test
    public void testChercheParCategorie() {
        articles = articleService.chercheParCategorie("Dic");
    }
    //*********************************************//

    //********Tester le method ChercheParCategorie*********//
    @Test
    public void testUpdated() {
        Article article = new Article();
        article.setTitre("hello Word !!");
        System.out.println(articleService.updateArticle(70,article));
    }
    //******************************************************//

    //********Tester le method ChercheParCategorie*********//
    @Test
    public void testdelete() {
        System.out.println(articleService.deleteArticle(45));
    }
    //******************************************************//


}
