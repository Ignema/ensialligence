package com.ensialligence.service;

import com.ensialligence.dao.JaimeDao;
import com.ensialligence.model.Jaime;
import com.ensialligence.config.PersistenceConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JaimeService implements JaimeDao {

	Connection connection= PersistenceConfig.connect();

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
	public void removeJaime(int idJaime) {
		try {

			PreparedStatement ps = connection.prepareStatement("delete from jaime where idjaime=?");
			ps.setInt(1, idJaime);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
