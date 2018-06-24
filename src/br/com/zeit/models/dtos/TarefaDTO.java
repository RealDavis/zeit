package br.com.zeit.models.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.zeit.interfaces.IDTO;

public class TarefaDTO implements IDTO{

	private int idTarefa;
	private String tarefa;
	private LocalDate data;
	private LocalTime hora;
	private String observacoes;
	private boolean isConcluido;
	private int idUsuario;

	public TarefaDTO() {
	}

	public int getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getTarefa() {
		return tarefa;
	}

	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public boolean isConcluido() {
		return isConcluido;
	}

	public void setConcluido(boolean isConcluido) {
		this.isConcluido = isConcluido;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@Override
	public boolean equals(Object obj) {
		TarefaDTO other = ((TarefaDTO)obj);
		if(idTarefa == other.getIdTarefa()) {
			return true;
		}
		return false;
	}

}