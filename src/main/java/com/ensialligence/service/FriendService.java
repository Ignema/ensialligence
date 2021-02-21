package com.ensialligence.service;

import com.ensialligence.dao.FriendDao;
import com.ensialligence.model.Friend;
import com.ensialligence.config.PersistenceConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendService implements FriendDao{
	
	Connection connection= PersistenceConfig.getConnection();

	@Override
	public Friend addFriend(Friend f) {
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO friend(user_1,user_2) VALUES (?,?)");
			ps.setInt(1, f.getIdUser1());
			ps.setInt(2, f.getIdUser2());
			ps.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(idfriend) AS MAX_ID FROM friend");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				f.setIdFriend(rs.getInt("MAX_ID"));
			}
			
			ps2.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		return f;	
	}

	@Override
	public void deleteFriend(Friend f) {
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("delete from friend where idfriend=?");
			ps.setInt(1, f.getIdFriend());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	//A
	@Override
	public List<Friend> getFriends(int idUser) { //list all friends of a user
		
		List<Friend> friends = new ArrayList<Friend>();
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM FRIEND WHERE user_1=? or user_2=?");
			ps.setInt(1, idUser);
			ps.setInt(2, idUser);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Friend f = new Friend();
				f.setIdFriend(rs.getInt("idfriend"));
				f.setIdUser1(rs.getInt("user_1"));
				f.setIdUser2(rs.getInt("user_2"));
				friends.add(f);
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return friends;
	}		

}

