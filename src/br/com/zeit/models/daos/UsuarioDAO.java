package br.com.zeit.models.daos;

import java.sql.SQLException;

import br.com.jestoque.security.Encript;
import br.com.zeit.db.ConnectionFactory;
import br.com.zeit.exceptions.EncriptionException;
import br.com.zeit.exceptions.PersistenciaException;
import br.com.zeit.models.dtos.UsuarioDTO;

public class UsuarioDAO extends GenericDAO<UsuarioDTO> {

	public boolean insertUsuario(UsuarioDTO usuario) throws PersistenciaException, EncriptionException {
		sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
			try {
				conn = ConnectionFactory.getConnection();
				pst = conn.prepareStatement(sql);
				pst.setString(1, usuario.getNome());
				pst.setString(2, usuario.getEmail());
				Encript encript = new Encript();
				pst.setString(3, encript.encriptPassword(usuario.getSenha()));
				
				return pst.executeUpdate() == 1;
			} catch (ClassNotFoundException | SQLException e) {
				throw new PersistenciaException("Erro de conexão com o banco de dados");
			}finally {
				try {
					closeResources();
				} catch (SQLException e) {
					throw new PersistenciaException("Erro de conexão com o banco de dados");
				}
			}
	}
	
	public UsuarioDTO getByEmail(String email) throws PersistenciaException {
		sql = "SELECT * FROM usuarios WHERE email = ?";
		UsuarioDTO usuario = null;
		try {
			conn = ConnectionFactory.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if(rs.first()) {
				usuario = new UsuarioDTO();
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail("email");
				return usuario;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException("Erro de conexão com o banco de dados");
		} finally {
			try {
				closeResources();
			} catch (SQLException e) {
				throw new PersistenciaException("Erro de conexão com o banco de dados");
			}
		}
		
		return usuario;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}