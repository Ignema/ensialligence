package com.ensialligence.service;

import com.ensialligence.dao.JaimeDao;
import com.ensialligence.model.Jaime;
import com.ensialligence.config.PersistenceConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JaimeDaoService implements JaimeDao {
	
	Connection connection= PersistenceConfig.getConnection();

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
