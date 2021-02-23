package com.ensialligence.service;

import com.ensialligence.dao.MessageDao;
import com.ensialligence.model.Message;
import com.ensialligence.config.PersistenceConfig;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageService implements MessageDao {
	
	Connection connection= PersistenceConfig.getConnection();

	@Override
	public Message saveMsg(Message m) {
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO message(msg,date_envoi,isread,sender,receiver) VALUES (?,?,?,?,?)");
			ps.setString(1, m.getMsg());
			ps.setString(2, m.getDate_envoi());
			ps.setBoolean(3, m.isRead());
			ps.setInt(4, m.getIdSender());
			ps.setInt(4, m.getIdReceiver());
			ps.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(idmsg) AS MAX_ID FROM message");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				m.setIdMsg(rs.getInt("MAX_ID"));
			}
			
			ps2.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		return m;
	}

	@Override
	public void deleteMsg(int idMsg) {
		
		Message m = new Message();
		try {
			
			PreparedStatement ps = connection.prepareStatement("delete from message where idmsg=?");
			ps.setInt(1, m.getIdMsg());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
	}
	

}
