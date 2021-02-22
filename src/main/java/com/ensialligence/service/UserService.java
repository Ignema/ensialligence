package com.ensialligence.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ensialligence.config.PersistenceConfig;
import com.ensialligence.dao.UserDao;
import com.ensialligence.model.Commentaire;
import com.ensialligence.model.User;

public class UserService implements UserDao {
	Connection connection= null;

	@Override
	public boolean addUser(User user) {
try {
			connection= PersistenceConfig.getConnection();
			
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
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
		 		
	}

	@Override
	public User findUser(String userName, String password) {
		
		connection= PersistenceConfig.getConnection();
		
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
				return user;
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new User();
	}

	@Override
	public boolean followUser(Long idUser) {
		// TODO Auto-generated method stub
		return false;
	}

}
