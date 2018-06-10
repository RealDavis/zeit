package br.com.zeit.models.daos;

import java.sql.SQLException;

import br.com.zeit.db.ConnectionFactory;
import br.com.zeit.exceptions.PersistenciaException;
import br.com.zeit.models.dtos.UsuarioDTO;

public class LoginDAO extends GenericDAO<UsuarioDTO> {

	public UsuarioDTO validarUsuario(UsuarioDTO usuario) throws PersistenciaException {
		UsuarioDTO usuarioValidado = null;
		sql = "SELECT id_usuario, nome FROM usuarios WHERE email = ? AND senha = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getSenha());
			rs = pst.executeQuery();
			if(rs.first()) {
				usuarioValidado = new UsuarioDTO();
				usuarioValidado.setIdUsuario(rs.getInt("id_usuario"));
				usuarioValidado.setNome(rs.getString("nome"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException("Erro no banco de dados");
		} finally {
			try {
				closeResources();
			} catch (SQLException e) {
				throw new PersistenciaException("Erro de conexão com o banco de dados");
			}
		}
		
		return usuarioValidado;
	}
	
}
