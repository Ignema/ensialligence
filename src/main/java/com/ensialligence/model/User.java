package com.ensialligence.model;

import java.io.Serializable;

public class User implements Serializable {
	
    private Long idUser;
    private String userName;
    private String passWd;
    
    public User(Long idUser,String userName,String passWd) {
        this.idUser=idUser;
        this.userName=userName;
        this.passWd=passWd;
    }
    
    public Long getIdUser() {
        return idUser;
    }
    
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassWd() {
        return passWd;
    }
    
    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }
}
