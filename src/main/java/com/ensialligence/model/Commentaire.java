package com.ensialligence.model;

import java.io.Serializable;

public class Commentaire implements Serializable {

    private int idCom;
    private int idUser;
    private int idArticle;
    private String comment;
    private int nbJaimeCom;

    public Commentaire() {
        super();
    }

    public Commentaire(int idCom, int idUser, int idArticle, String comment, int nbJaimeCom) {
        super();
        this.idCom = idCom;
        this.idUser = idUser;
        this.idArticle = idArticle;
        this.comment = comment;
        this.nbJaimeCom = nbJaimeCom;
    }

    public int getIdCom() {
        return idCom;
    }

    public void setIdCom(int idCom) {
        this.idCom = idCom;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String the_comment) {
        this.comment = the_comment;
    }

    public int getNbJaimeCom() {
        return nbJaimeCom;
    }

    public void setNbJaimeCom(int nbJaimeCom) {
        this.nbJaimeCom = nbJaimeCom;
    }

    @Override
    public String toString() {
        return "Commentaire [idCom=" + idCom + ", idUser=" + idUser + ", idArticle=" + idArticle + ", comment="
                + comment + ", nbJaimeCom=" + nbJaimeCom + "]";
    }



}
