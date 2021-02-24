package com.ensialligence.model;

import java.io.File;
import java.io.Serializable;

public class Article implements Serializable {
	
	
	private int idarticle;                  
    public int id ;                  
    public String titre;                          
    public String categorie;                      
    public String image;
    public String video;
    public int nbjaimeart;
    
    
	public int getIdarticle() {
		return idarticle;
	}
	public void setIdarticle(int idarticle) {
		this.idarticle = idarticle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public int getNbjaimeart() {
		return nbjaimeart;
	}
	public void setNbjaimeart(int nbjaimeart) {
		this.nbjaimeart = nbjaimeart;
	}
	/*@Override
	public String toString() {
		return "Article [idarticle=" + idarticle + ", id=" + id + ", titre=" + titre + ", categorie=" + categorie
				+ ", image=" + image + ", video=" + video + ", nbjaimeart=" + nbjaimeart + "]";
	} */
    
    

}
