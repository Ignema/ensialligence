package com.ensialligence.web.rest.ArticleDAO;

import com.ensialligence.web.rest.modelArticle.Article;

import java.io.File;
import java.util.List;


public interface ArticleDAO {

	public String save(int id, String Titre, String Categorie, File image , File video, int nbjaimeart);
	public List<Article> chercheParTitre(String titre);
	public List<Article> chercheParCategorie(String categorie);
	public List<Article> getAricles();
	public boolean updateArticle(int idarticle,Article article);
	public String deleteArticle(int id_article);
}
