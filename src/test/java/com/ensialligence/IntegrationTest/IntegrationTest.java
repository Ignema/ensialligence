package com.ensialligence.IntegrationTest;

import com.ensialligence.model.Article;
import com.ensialligence.model.Commentaire;
import com.ensialligence.model.Friend;
import com.ensialligence.model.Jaime;
import com.ensialligence.service.ArticleService;
import com.ensialligence.service.CommentaireService;
import com.ensialligence.service.FriendService;
import com.ensialligence.service.JaimeService;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class IntegrationTest {



    ArticleService articleService = new ArticleService();
    JaimeService jaime = new JaimeService();
    CommentaireService com = new CommentaireService();
    FriendService friend = new FriendService();


    @Test
    public void main(){
        //**************On va commencer Par creer un Compte dans l'application **************//
        int idUser = 2 ;

        //*************l'utilisateur veut visualiser l'ensemble des articles**********//
        List<Article> articles = articleService.getAricles();

        //***********l'utilisateur veut chercher l'ensemble des article par categorie //

        String Mot_cle ="java";
        List<Article> articleParCat = articleService.chercheParCategorie(Mot_cle);

        //************l'utiisateur a aime une article **********************//
        jaime.addJaime(new Jaime(idUser, 26));

        //***********l'utilisateur veut ajoutez son commentaire******************//
        Commentaire c = new Commentaire(1, idUser,26,"c pas vrai !!! ", 0);
        com.addComment(c);
        //***********l'utilisateur veut Modifier son commentaire ***********//
        c.setComment("ça arrive mais pas tout temps , Faut pas generaliser !");
        com.updateComment(c);

        //*********l'utilisateur veut Ajouter une Article*************************//
        File img = new File("C:/Users/Lenovo\\Desktop/MyworkSpace/ProjetSIAPP/memories.png");
        articleService.save(idUser,"Devellopemt WEB","JEE",img,null,20);

        //************l'utilisateur veut supprimer son commentaire *********************//
        com.deleteComment(1);

        //**********l'utilisateur veut ajouter un ami *******************//
        friend.addFriend(new Friend(idUser, 3));

    }
}
