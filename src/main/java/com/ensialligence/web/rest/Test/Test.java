package com.ensialligence.web.rest.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ensialligence.web.rest.ArticleDAO.ArticleDAOImp;
import com.ensialligence.web.rest.modelArticle.Article;



public class Test {

	public static void main(String[] args) {
		ArticleDAOImp aticleDAOimp = new ArticleDAOImp();
		Article art = new Article();
		File img = new File("C:/Users/Lenovo\\Desktop/MyworkSpace/ProjetSIAPP/memories.png");
		art.setIdarticle(248);
		art.setId(2);
		art.setTitre("hiba");
		art.setCategorie("abih");
		//art.setImage(img);
		art.setVideo(null);
		art.setNbjaimeart(50);
		String article = aticleDAOimp.save(2,"hiba","hiba",img,null,20);
		
		List<Article> articles = aticleDAOimp.getAricles();
		for(Article a : articles) {
			System.out.println(a);
		}
		List<Article> article1 = new ArrayList<>();
		Scanner S  = new Scanner(System.in);
		System.out.print("rechercher par tire : ");
		article1 = aticleDAOimp.chercheParTitre(S.next());
		System.out.print("rechercher par Categorie : ");
		article1 = aticleDAOimp.chercheParCategorie(S.next());
		for(Article a : article1) {
			System.out.println(a);
		}

		Article artup= art;
		artup.setTitre("hello dear hiba !!");
		aticleDAOimp.updateArticle(248,artup);
		List<Article> articles2 = aticleDAOimp.getAricles();
		for(Article a : articles2) {
			System.out.println(a);
		}

		//System.out.println(aticleDAOimp.deleteArticle(248));
	}
}
