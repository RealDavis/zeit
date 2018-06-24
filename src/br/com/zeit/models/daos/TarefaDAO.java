package br.com.zeit.models.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;

import br.com.zeit.db.ConnectionFactory;
import br.com.zeit.exceptions.PersistenciaException;
import br.com.zeit.models.dtos.TarefaDTO;

public class TarefaDAO extends GenericDAO<TarefaDTO> {

	@Override
	public boolean insert(TarefaDTO tarefa) throws PersistenciaException {
		String sql = "INSERT INTO tarefas (tarefa, data_tarefa, hora, "
				+ "observacoes, is_concluido, id_usuario) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, tarefa.getTarefa());
			if(tarefa.getData() != null) {
				pst.setDate(2, Date.valueOf(tarefa.getData()));
			} else {
				pst.setNull(2, Types.DATE);
			}
			if(tarefa.getHora() != null) {
				pst.setTime(3, Time.valueOf(tarefa.getHora()));
			} else {
				pst.setNull(3, Types.TIME);
			}
			pst.setString(4, tarefa.getObservacoes());
			pst.setBoolean(5, tarefa.isConcluido());
			pst.setInt(6, tarefa.getIdUsuario());
			return pst.executeUpdate() == 1;
		}  catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage());
		}finally {
			try {
				closeResources();
			} catch (SQLException e) {
				throw new PersistenciaException("Erro de conexão com o banco de dados");
			}
		}
	}
	
}
