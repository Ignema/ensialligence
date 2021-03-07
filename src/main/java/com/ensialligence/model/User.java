package com.ensialligence.model;

import java.io.Serializable;

import com.google.protobuf.Timestamp;

public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String mail;
    private String date_nais;
    
    public User() {
		super();
	}  
    
    public User(String username, String password, String firstname, String lastname, String mail,
			String date_nais) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.date_nais = date_nais;
	}

	public User(Long id, String username, String password, String firstname, String lastname, String mail,
			String date_nais) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.date_nais = date_nais;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDate_nais() {
		return date_nais;
	}

	public void setDate_nais(String date_nais) {
		this.date_nais = date_nais;
	}
    
    
}
