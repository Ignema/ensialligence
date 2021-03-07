package com.ensialligence.service;

import com.ensialligence.config.SingleConnection;
import com.ensialligence.dao.ArticleDAO;
import com.ensialligence.model.Article;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ArticleService implements ArticleDAO {
    Connection connection = SingleConnection.getConnection();

    @Override
    public Article save(int id, String Titre, String Categorie, File image, File video, int nbjaimeart) {
        Article article = new Article();
        try {
            Statement stat=connection.createStatement();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO article (id,titre,categorie,image,video,nbjaimeart) VALUES (?,?,?,?,?,?)");
           // ps.setInt(1, 212);
            ps.setInt(1, id);article.setId(id);
            ps.setString(2, Titre);article.setTitre(Titre);
            ps.setString(3, Categorie);article.setCategorie(Categorie);
            if(image == null) ps.setString(4, null);
            else{ byte[] fileContent = FileUtils.readFileToByteArray(image);
            ps.setString(4, Base64.getEncoder().encodeToString(fileContent));
            article.setImage(Base64.getEncoder().encodeToString(fileContent));
            }
            ps.setString(5, null);article.setVideo(null);
            ps.setInt(6, nbjaimeart);article.setNbjaimeart(nbjaimeart);
            ps.executeUpdate();

            ps.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public List<Article> chercheParTitre(String titre) {
        List<Article> articles = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM article where titre LIKE ? ;");
            ps.setString(1,"%"+titre+"%");
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while(rs.next()) {
                Article article = new Article();
                article.setIdarticle(rs.getInt("idarticle"));
                article.setId(rs.getInt("id"));
                article.setTitre(rs.getString("titre"));
                article.setCategorie(rs.getString("categorie"));
                article.setImage(rs.getString("image"));
                article.setVideo(null);
                article.setNbjaimeart(rs.getInt("nbjaimeart"));

                articles.add(article);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public List<Article> chercheParCategorie(String categorie) {
        List<Article> articles = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM article where categorie LIKE ? ;");
            ps.setString(1,"%"+categorie+"%");
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while(rs.next()) {
                Article article = new Article();
                article.setIdarticle(rs.getInt("idarticle"));
                article.setId(rs.getInt("id"));
                article.setTitre(rs.getString("titre"));
                article.setCategorie(rs.getString("categorie"));
                article.setImage(rs.getString("image"));
                article.setVideo(null);
                article.setNbjaimeart(rs.getInt("nbjaimeart"));

                articles.add(article);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public List<Article> getAricles() {
        List<Article> articles = new ArrayList<>();
        try {
            Statement stat=connection.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM article;");
                while (rs.next()) {
                    Article article = new Article();
                    article.setIdarticle(rs.getInt("idarticle"));
                    article.setId(rs.getInt("id"));
                    article.setTitre(rs.getString("titre"));
                    article.setCategorie(rs.getString("categorie"));
                    article.setImage(rs.getString("image"));
                    article.setVideo(null);
                    article.setNbjaimeart(rs.getInt("nbjaimeart"));
                    articles.add(article);
                }

        }catch(Exception e) {
            e.printStackTrace();
        }return articles;
    }

    @Override
    public Article updateArticle(int idarticle,Article article) {
        boolean cle =  false;
        Article articlerst = new Article();
        articlerst.setIdarticle(idarticle);
        articlerst.setId(article.getId());
        articlerst.setTitre(article.getTitre());
        articlerst.setCategorie(article.getCategorie());
        articlerst.setVideo(article.getVideo());
        articlerst.setImage(article.getImage());
        articlerst.setNbjaimeart(article.getNbjaimeart());
        try {
            PreparedStatement prep = connection.prepareStatement("update article set titre='"+article.getTitre()+"',categorie='"+article.getCategorie()+"'  where idarticle="+idarticle+";");
            prep.executeUpdate();
            prep.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return articlerst;
    }

    @Override
    public String deleteArticle(int idarticle) {
        boolean cle =  false;
        try {
            PreparedStatement prep = connection.prepareStatement("DELETE FROM article WHERE idarticle ="+idarticle+";");
            prep.executeUpdate();
            prep.close();
            cle=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "The article was successfuly deleted !";
    }
}
