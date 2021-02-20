package com.ensialligence.Test;

import com.ensialligence.DAO.InterfacesImpl.CommentaireImpl;
import com.ensialligence.DAO.InterfacesImpl.JaimeImpl;
import com.ensialligence.Models.Commentaire;
import com.ensialligence.Models.Jaime;

public class TestDAO {
	
	public static void main(String[] args) {
		
		JaimeImpl  daoJ = new JaimeImpl();
		Jaime j = daoJ.addJaime(new Jaime(5,10));
		System.out.println(j.toString());
		
		CommentaireImpl  daoC = new CommentaireImpl();
		Commentaire c = new Commentaire();
		c.setIdUser(20);
		c.setIdArticle(48);
		c.setComment("first comment");
		c.setNbJaimeCom(0);
		daoC.addComment(c);
		System.out.println(c.toString());
		System.out.println("Comment added with the ID = "+c.getIdCom());
	}

}
