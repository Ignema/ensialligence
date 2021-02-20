package com.ensialligence.DAO.InterfacesImpl;

import com.ensialligence.DAO.Interfaces.IJaime;
import com.ensialligence.Models.Jaime;
import com.ensialligence.DAO.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JaimeImpl implements IJaime {
	
	Connection connection= SingletonConnection.getConnection();

	@Override
	public Jaime addJaime(Jaime j) {
		try {
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO jaime(id,idarticle) VALUES (?,?)");
			ps.setInt(1, j.getIdUser());
			ps.setInt(2, j.getIdArticle());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		return j;
	}

	@Override
	public void removeJaime(Jaime j) {
		try {
			
			PreparedStatement ps = connection.prepareStatement("delete from jaime where id=? and idarticle=?");
			ps.setInt(1, j.getIdUser());
			ps.setInt(2, j.getIdArticle());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}		
	
}
