package com.ensialligence.model;

import java.io.Serializable;

public class Jaime implements Serializable{
	
	private int idUser;
	private int idArticle;
	
	public Jaime() {
		super();
	}
	
	public Jaime(int idUser, int idArticle) {
		super();
		this.idArticle = idArticle;
		this.idUser = idUser;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Jaime [idUser=" + idUser + ", idArticle=" + idArticle + "]";
	}
	
	
}
