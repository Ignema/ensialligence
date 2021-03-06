package com.ensialligence.dao;

import java.util.List;

import com.ensialligence.model.Commentaire;

public interface CommentaireDao {
	
	Commentaire addComment(Commentaire c);
	
	Commentaire getCommentById(int idCom);
	
	List<Commentaire> getComments(int idArticle);
	
	Commentaire updateComment(Commentaire c);
	
	void deleteComment(int idCom);
}
