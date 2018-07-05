package br.com.zeit.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.zeit.db.ConnectionFactory;
import br.com.zeit.exceptions.EncriptionException;
import br.com.zeit.exceptions.PersistenciaException;
import br.com.zeit.models.dtos.UsuarioDTO;
import br.com.zeit.security.Encript;

public class UsuarioDAO {

	public boolean insertUsuario(UsuarioDTO usuario) throws PersistenciaException, EncriptionException{
		String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			Encript encript = new Encript();
			pst.setString(3, encript.encriptPassword(usuario.getSenha()));
			
			return pst.executeUpdate() == 1;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException("Erro de conexão com o banco de dados");
		}
	}
	
	public UsuarioDTO getByEmail(String email) throws PersistenciaException {
		String sql = "SELECT * FROM usuarios WHERE email = ?";
		UsuarioDTO usuario = null;
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.first()) {
				usuario = new UsuarioDTO();
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail("email");
				return usuario;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException("Erro de conexão com o banco de dados");
		} 
		
		return usuario;
	}

}