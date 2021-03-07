package com.ensialligence.UnitTest;

import com.ensialligence.model.Article;
import com.ensialligence.model.Commentaire;
import com.ensialligence.service.CommentaireService;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;
import java.io.File;
import java.util.List;

public class CommentaireTest {

    CommentaireService com = new CommentaireService();

    //************* Tester la method addCom ************//
    @Test
    public void AddCom() {
        Commentaire c = new Commentaire(1, 6,13," add a comment", 12);
        com.addComment(c);
    }
    //**************************************************//

    //*********** Tester la method comsByArticle*********//
    @Test
    public void testComsByArticle() {

        List<Commentaire> Coms =  com.getComments(13);
        assertEquals(13,Coms.get(0).getIdArticle());
    }
    //**********************************************//
    //*********** Tester la method comById*********//
    @Test
    public void testComById() {

        Commentaire Com =  com.getCommentById(6);
        assertEquals(6,Com.getIdCom());
    }
    //**********************************************//
    //********Tester le method deleteCom*********//
    @Test
    public void testdeleteCom() {

        com.deleteComment(1);
        assertEquals(0,com.getCommentById(1).getIdCom());
    }
    //******************************************************//

    //********Tester le method updateCom*********//
    @Test
    public void testupdateCom() {

         com.updateComment(new Commentaire(6,1,1, "Why ",6));
    }
    //******************************************************//
}
