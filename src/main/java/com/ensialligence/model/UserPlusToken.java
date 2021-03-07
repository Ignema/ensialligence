package com.ensialligence.model;

public class UserPlusToken {
	User user;
	String token;
	
	public UserPlusToken() {
		super();
	}
	
	public UserPlusToken(User user){
		this.token=Token.generateNewToken();
		this.user= user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
