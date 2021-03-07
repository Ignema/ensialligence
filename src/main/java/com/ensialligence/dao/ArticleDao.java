package com.ensialligence.dao;

import com.ensialligence.model.Article;

import java.io.File;
import java.util.List;


public interface ArticleDao {

	public Article save(int id, String Titre, String Categorie, File image , File video, int nbjaimeart);
	public List<Article> chercheParTitre(String titre);
	public List<Article> chercheParCategorie(String categorie);
	public List<Article> getAricles();
	public Article updateArticle(int idarticle,Article article);
	public String deleteArticle(int id_article);
}
