package com.ensialligence.DAO.Interfaces;

import java.util.List;

import com.ensialligence.Models.Commentaire;

public interface ICommentaire {
	
	public Commentaire addComment(Commentaire c);
	
	public List<Commentaire> getComments(int idArticle);
	
	public Commentaire updateComment(Commentaire c);
	
	public void deleteComment(Commentaire c);
}
