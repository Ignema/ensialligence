package com.ensialligence.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.io.*;
import java.sql.*;


import com.ensialligence.dao.ArticleDAO;
import com.ensialligence.config.SingleConnection;
import com.ensialligence.model.Article;
import org.apache.commons.io.FileUtils;


public class ArticleDAOImp implements ArticleDAO {
	
  
	Connection connection = SingleConnection.getConnection();

	@Override
	public String save(int id,String Titre,String Categorie,File image , File video, int nbjaimeart) {
		
		try {
			//File file = article.getImage();
		   // FileInputStream input = new FileInputStream(file);
			Statement stat=connection.createStatement();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO article (idarticle,id,titre,categorie,image,video,nbjaimeart) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, 266);
			ps.setInt(2, id);
			ps.setString(3, Titre);
			ps.setString(4, Categorie);
			//ps.setBinaryStream(5,(InputStream)input,(int)file.length());
			//byte[] fileContent = FileUtils.readFileToByteArray(image);
			//String encodedString = Base64.getEncoder().encodeToString(fileContent);
			//ps.setString(4, Base64.getEncoder().encodeToString(fileContent));
			if(image == null) ps.setString(5, null);
			else{ byte[] fileContent = FileUtils.readFileToByteArray(image);
				ps.setString(5, Base64.getEncoder().encodeToString(fileContent));
			}
			ps.setString(6, null);
			ps.setInt(7, nbjaimeart);
			ps.executeUpdate();
			
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "The article was succesfuly saved !!";
		
	}

	@Override
	public List<Article> chercheParTitre(String titre){
		List<Article> articles = new ArrayList<>();
		try{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM article where titre LIKE ? ;");
			ps.setString(1,"%"+titre+"%");
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while(rs.next()) {
				Article article = new Article();
				/*InputStream input = rs.getBinaryStream(5);
				if(input!=null) {
					File img = new File(" C:/Users/Lenovo\\Desktop/MyworkSpace/titre"+i+".jpg");
					OutputStream output = new FileOutputStream(img);
					i++;
					int b = 0;
					while ((b = input.read()) > -1) {
						output.write(b);
					}
					article.setImage(img);
					output.close();
					input.close();
				}
				else article.setImage(null);
				*/

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
				/*InputStream input = rs.getBinaryStream(5);
				if(input!=null) {
					File img = new File("C:/Users/Lenovo\\Desktop/MyworkSpace/ProjetSIAPP/titre"+i+".jpg");
					OutputStream output = new FileOutputStream(img);
					i++;
					int b = 0;
					while ((b = input.read()) > -1) {
						output.write(b);
					}
					article.setImage(img);
					output.close();
					input.close();
				}
				else article.setImage(null);
				*/

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
			ResultSet rs = stat.executeQuery( "SELECT * FROM article;" );
			int i = 2;
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
		}return articles;
	}

	@Override
	public String updateArticle(int idarticle,Article article) {
		boolean cle =  false;
		try {
			PreparedStatement prep = connection.prepareStatement("update article set titre='"+article.getTitre()+"',categorie='"+article.getCategorie()+"'  where idarticle="+idarticle+";");
			prep.executeUpdate();
			prep.close();
			cle=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "true";
	}


	@Override
	public String  deleteArticle(int idarticle) {
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
