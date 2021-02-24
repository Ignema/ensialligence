package com.ensialligence.dao;

import com.ensialligence.model.Article;

import java.io.File;
import java.util.List;


public interface ArticleDAO {

	public String save(int id, String Titre, String Categorie, File image , File video, int nbjaimeart);
	public List<Article> chercheParTitre(String titre);
	public List<Article> chercheParCategorie(String categorie);
	public List<Article> getAricles();
	public String updateArticle(int idarticle,Article article);
	public String deleteArticle(int id_article);
}
