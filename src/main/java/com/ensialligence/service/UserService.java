package com.ensialligence.service;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;

import com.ensialligence.config.PersistenceConfig;
import com.ensialligence.dao.UserDao;
import com.ensialligence.model.Commentaire;
import com.ensialligence.model.Token;
import com.ensialligence.model.User;
import com.ensialligence.model.UserPlusToken;

public class UserService implements UserDao {
	Connection connection= null;
	
	public UserService() {
		connection= PersistenceConfig.getInstance().connect();
	}


	@Override
	public String addUser(User user) {
		try {
			//connection= PersistenceConfig.getConnection();
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `utilisateur`"
																+ "(`username`, `password`, `firstname`, `lastname`, `email`, `date_nais`)"
																+ " VALUES (?,?,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setString(5, user.getMail());
			ps.setString(6, user.getDate_nais());
			ps.executeUpdate();
			
			ps.close();
			return  Token.generateNewToken();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return null;
		 		
	}

	@Override
	public UserPlusToken findUser(String userName, String password) {
		
		//connection= PersistenceConfig.getConnection();
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM `utilisateur` WHERE username =? AND password =?");
			ps.setString(1, userName);
			ps.setString(2, password);
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				User user= new User(rs.getLong("id"), 
									rs.getString("username"),
									rs.getString("password") ,
									rs.getString("firstname"), 
									rs.getString("lastname"), 
									rs.getString("email"), 
									rs.getString("date_nais"));
				return new UserPlusToken(user);
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new UserPlusToken();
	}

	@Override
	public boolean followUser(Long idUser1, Long idUser2) {
		
		try {
			//connection= PersistenceConfig.getConnection();
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `friend`(`user_1`, `user_2`) VALUES (?,?)");
			ps.setLong(1, idUser1);
			ps.setLong(2, idUser2);
			ps.executeUpdate();
			ps.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public ArrayList<User> listFriends(Long idUser) {
		//connection= PersistenceConfig.getConnection();
		ArrayList<User> listUser=new ArrayList<>();
		HashSet<Long> listId=new HashSet<>();
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM `friend` WHERE `user_1`=? OR `user_2`=?");
			ps.setLong(1, idUser);
			ps.setLong(2, idUser);
			
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getLong("user_1")!=idUser)listId.add(rs.getLong("user_1"));
				if(rs.getLong("user_2")!=idUser)listId.add(rs.getLong("user_2"));
			}
			System.out.println(listId);
			for(Long id:listId) {
				listUser.add(findUserById(id));
			}
			
			ps.close();
			return listUser;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	

	@Override
	public User findUserById(Long idUser) {
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM `utilisateur` WHERE id=?");
			ps.setLong(1, idUser);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				User user= new User(rs.getLong("id"), 
									rs.getString("username"),
									rs.getString("password") ,
									rs.getString("firstname"), 
									rs.getString("lastname"), 
									rs.getString("email"), 
									rs.getString("date_nais"));
				return user;
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new User();
	}


	

}
