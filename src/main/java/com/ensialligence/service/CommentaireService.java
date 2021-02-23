package com.ensialligence.service;

import com.ensialligence.dao.CommentaireDao;
import com.ensialligence.model.Commentaire;
import com.ensialligence.config.PersistenceConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentaireService implements CommentaireDao {
	
	Connection connection= PersistenceConfig.getConnection();

	@Override
	public Commentaire addComment(Commentaire c) {
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO commentaire(id,idarticle,the_comment,nbjaimecom) VALUES (?,?,?,?)");
			ps.setInt(1, c.getIdUser());
			ps.setInt(2, c.getIdArticle());
			ps.setString(3, c.getComment());
			ps.setInt(4, c.getNbJaimeCom());
			ps.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(idcom) AS MAX_ID FROM commentaire");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				c.setIdCom(rs.getInt("MAX_ID"));
			}
			
			ps2.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		return c;
	}

	@Override
	public Commentaire getCommentById(int idCom) {
		
		Commentaire c = new Commentaire();		
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM commentaire WHERE idcom="+idCom);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setIdCom(idCom);
				c.setIdUser(rs.getInt("id"));
				c.setIdArticle(rs.getInt("idarticle"));
				c.setComment(rs.getString("the_comment"));
				c.setNbJaimeCom(rs.getInt("nbjaimecom"));
			}
		ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public List<Commentaire> getComments(int idArticle) { //list all comments of an article
		
		List<Commentaire> comments=new ArrayList<Commentaire>();
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM COMMENTAIRE WHERE idarticle=?");
			ps.setInt(1, idArticle);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Commentaire c = new Commentaire();
				c.setIdCom(rs.getInt("idcom"));
				c.setIdUser(rs.getInt("id"));
				c.setIdArticle(rs.getInt("idarticle"));
				c.setComment(rs.getString("the_comment"));
				c.setNbJaimeCom(rs.getInt("nbjaimecom"));
				comments.add(c);
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return comments;
	}

	
	@Override
	public Commentaire updateComment(Commentaire c) {
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("UPDATE commentaire SET id=?,idarticle=?,the_comment=?,nbjaimecom=? WHERE idcom=?");
			ps.setInt(1, c.getIdUser());
			ps.setInt(2, c.getIdArticle());
			ps.setString(3, c.getComment());
			ps.setInt(4, c.getNbJaimeCom());
			ps.setInt(5, c.getIdCom());
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		return c;
	}

	
	@Override
	public void deleteComment(int idCom){
				
		try {
			
			PreparedStatement ps = connection.prepareStatement("delete from commentaire where idcom=?");
			ps.setInt(1, idCom);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}


	

}
