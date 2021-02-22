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
	
	/**
	 * 
	 * @param idUser the id of the user that we want to add to our friend's list
	 * @return false cas d'erreur d'ajout; true sinon
	 */
	boolean followUser(Long idUser);

}
