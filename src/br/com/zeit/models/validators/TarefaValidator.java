package br.com.zeit.models.validators;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.zeit.models.dtos.TarefaDTO;

public class TarefaValidator {

	private StringBuilder msgErro = null;
	
	public TarefaValidator() {
		msgErro = new StringBuilder();
	}
	
	public String validar(TarefaDTO tarefa) {
		validarTarefa(tarefa.getTarefa());
		if(tarefa.getData() != null) {
			validarData(tarefa.getData());
		}
		if(tarefa.getHora() != null) {
			validarHora(tarefa.getData(), tarefa.getHora());
		}
		return msgErro.toString().trim();
	}

	private void validarTarefa(String tarefa) {
		if(tarefa == null || tarefa.isEmpty()) {
			msgErro.append("Preencha o campo tarefa.<br>\n");
		} else if(tarefa.length() < 5) {
			msgErro.append("Tarefa inválida. A tarefa deve ter no minimo 5 caracteres.<br>\n");
		}
	}
	
	private void validarData(LocalDate data) {
		LocalDate now = LocalDate.now();
		if(data.isBefore(now)) {
			msgErro.append("Data inválida. A data deve ser igual ou posterior a data atual.<br>\n");
		}
	}
	
	private void validarHora(LocalDate data, LocalTime hora) {
		if(data == null) {
			msgErro.append("Selecione uma data e então selecione um horário.<br>\n");
		} else if(data.equals(LocalDate.now()) && hora.isBefore(LocalTime.now())) {
			msgErro.append("Horário inválido. Selecione um horário posterior ao atual.<br>\n");
		}
	}
	
}
