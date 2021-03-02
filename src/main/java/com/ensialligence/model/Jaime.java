package com.ensialligence.model;


import java.io.Serializable;

public class Jaime implements Serializable {

    private int idJaime;
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

    public Jaime(int idJaime, int idUser, int idArticle) {
        super();
        this.idJaime = idJaime;
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

    public int getIdJaime() {
        return idJaime;
    }

    public void setIdJaime(int idJaime) {
        this.idJaime = idJaime;
    }

    @Override
    public String toString() {
        return "Jaime [idJaime=" + idJaime + ", idUser=" + idUser + ", idArticle=" + idArticle + "]";
    }



}
