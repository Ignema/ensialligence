package com.ensialligence.model;

import java.io.Serializable;

public class Friend implements Serializable {
	
	private int idFriend;
	private int idUser1;
	private int idUser2;
	
	public Friend() {
		super();
	}

	public Friend(int idFriend, int idUser1, int idUser2) {
		super();
		this.idFriend = idFriend;
		this.idUser1 = idUser1;
		this.idUser2 = idUser2;
	}

	public int getIdFriend() {
		return idFriend;
	}

	public void setIdFriend(int idFriend) {
		this.idFriend = idFriend;
	}

	public int getIdUser1() {
		return idUser1;
	}

	public void setIdUser1(int idUser1) {
		this.idUser1 = idUser1;
	}

	public int getIdUser2() {
		return idUser2;
	}

	public void setIdUser2(int idUser2) {
		this.idUser2 = idUser2;
	}

	@Override
	public String toString() {
		return "Friend [idFriend=" + idFriend + ", idUser1=" + idUser1 + ", idUser2=" + idUser2 + "]";
	}
	
	
	
}
