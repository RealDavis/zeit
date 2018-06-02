package br.com.zeit.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.zeit.exceptions.PersistenciaException;
import br.com.zeit.interfaces.IDAO;

public class GenericDAO<T> implements IDAO<T>{

	protected String sql = null;
	protected Connection conn = null;
	protected PreparedStatement pst = null;
	protected ResultSet rs = null;
	
	@Override
	public boolean insert(T obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(T obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> getAll() throws PersistenciaException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getByid(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void closeResources() throws SQLException {
		if(conn != null) {
			conn.close();
		} 
		if(pst != null) {
			pst.close();
		}
		if(rs != null) {
			rs.close();
		}
	}
	
}
