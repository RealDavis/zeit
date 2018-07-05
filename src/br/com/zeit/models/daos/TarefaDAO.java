package br.com.zeit.models.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;

import br.com.zeit.db.ConnectionFactory;
import br.com.zeit.exceptions.PersistenciaException;
import br.com.zeit.models.dtos.TarefaDTO;

public class TarefaDAO {

	public boolean insert(TarefaDTO tarefa) throws PersistenciaException {
		String sql = "INSERT INTO tarefas (tarefa, data_tarefa, hora, "
				+ "observacoes, is_concluido, id_usuario) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
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
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException("Erro de conexão com o banco de dados");
		}
	}
	
	public boolean concluir(int idTarefa) throws PersistenciaException {
		String sql = "UPDATE tarefas SET is_concluido = TRUE WHERE id_tarefa = ?";
		try(Connection conn = ConnectionFactory.getConnection();) {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idTarefa);
			if(pst.executeUpdate() == 1) {
				return true;
			}
			return false;
		}  catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage());
		}
	}

	public boolean excluir(int idTarefa) throws PersistenciaException {
		String sql = "DELETE FROM tarefas WHERE id_tarefa = ?";
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idTarefa);
			if(pst.executeUpdate() == 1) {
				return true;
			}
			return false;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException("Erro de conexão com o banco de dados");
		}
	}
	
	public TarefaDTO getById(int idTarefa) throws PersistenciaException {
		String sql = "SELECT * FROM tarefas WHERE id_tarefa = ?";
		TarefaDTO tarefa = null;
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idTarefa);
			ResultSet rs = pst.executeQuery();
			if(rs.first()) {
				tarefa = new TarefaDTO();
				tarefa.setIdTarefa(rs.getInt("id_tarefa"));
				tarefa.setTarefa(rs.getString("tarefa"));
				
				tarefa.setData(rs.getDate("data_tarefa") != null ? rs.getDate("data_tarefa").toLocalDate() : null);
				tarefa.setHora(rs.getTime("hora") != null ? rs.getTime("hora").toLocalTime() : null);
				tarefa.setObservacoes(rs.getString("observacoes"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException("Erro de conexão com o banco de dados");
		}
		return tarefa;
	}
	
	public boolean update(TarefaDTO tarefa) throws PersistenciaException {
		String sql = "UPDATE tarefas SET tarefa = ?, data_tarefa = ?, "
				+ "hora = ?, observacoes = ? WHERE id_tarefa = ?";
		try(Connection conn = ConnectionFactory.getConnection()) {
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
			pst.setInt(5, tarefa.getIdTarefa());
			return pst.executeUpdate() == 1;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException("Erro de conexão com o banco de dados");
		}
	}
	
}