package com.ensialligence.dao;

import com.ensialligence.model.User;

public interface UserDao {
	
	/**
	 * 
	 * @param userName le nom d'utilisateur lors d'authentification
	 * @param password le password    "       "      "
	 * @return l'utilisateur qu'on cherche
	 */
	 User findUser(String userName,String password);
	/**
	 * 
	 * @param user c'est l'utilieateur qu'on va ajouté
	 * @return true si il est bien ajouter; false sinon
	 */
	boolean addUser (User user);

}
