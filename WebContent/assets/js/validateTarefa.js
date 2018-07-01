//variaveis para tarefa
let tarefa = document.getElementById("tarefa");
let tarefaClass = tarefa.className;
let erroTarefa = document.getElementById("erroTarefa");
//variaveis para data
let dataTarefa = document.getElementById("data");
let dataTarefaClass = dataTarefa.className;
let erroData = document.getElementById("erroData");
//variaveis para hora
let hora = document.getElementById("hora");
let horaClass = hora.className;
let erroHora = document.getElementById("erroHora");

let resultado = [];

tarefa.onchange = () => {
	if(tarefa.value.length < 5 || tarefa.value.lenght > 100) {
		tarefa.className = tarefaClass + " is-invalid";
		erroTarefa.innerHTML = "A tarefa deve ter entre 5 e 100 caracteres";
		resultado[0] = false;
	} else {
		tarefa.className = tarefaClass + " is-valid";
		erroTarefa.innerHTML = "";
		resultado[0] = true;
	}
}

dataTarefa.onchange = () => {
	if(dataTarefa.value != "") {
		let aux = dataTarefa.value.split("-");
		let d = new Date();
		d.setFullYear(parseInt(aux[0]));
		d.setMonth(parseInt(aux[1]));
		d.setDate(parseInt(aux[2]));
		let hoje = new Date();
		
		if(d < hoje) {
			dataTarefa.className = dataTarefaClass + " is-invalid";
			erroData.innerHTML = "Data inválida. Selecione uma data igual ou posterior a atual."
			resultado[1] = false;
		} else {
			dataTarefa.className = dataTarefaClass + " is-valid";
			resultado[1] = true;
		}
	}
}

hora.onchange = () => {
	if(dataTarefa.value === "") {
		hora.className = horaClass + " is-invalid";
		erroHora.innerHTML = "Selecione uma data primeiro";
		resultado[2] = false;
	} else {
		let d = new Date();
		aux = hora.value.split(":");
		d.setHours(parseInt(aux[0]));
		d.setMinutes(parseInt(aux[1]));
		let hoje = new Date();
	
		if(d.getHours() < hoje.getHours()) {
			hora.className = horaClass + " is-invalid";
			erroHora.innerHTML = "Selecione um horário posterior ao atual";
			resultado[2] = false;
		} else if(d.getHours() === hoje.getHours() && d.getMinutes() < hoje.getMinutes()) {
			hora.className = horaClass + " is-invalid";
			erroHora.innerHTML = "Selecione um horário posterior ao atual";
			resultado[2] = false;
		} else {
			hora.className = horaClass + " is-valid";
			resultado[2] = true;
		}
	}
}

function validarTarefa() {
	if(tarefa.value == "") {
		tarefa.className = tarefaClass + " is-invalid";
		erroTarefa.innerHTML = "A tarefa deve ter entre 5 e 100 caracteres";
		return false;
	} else {
		for (let i = 0; i < resultado.length; i++) {
			if(resultado[i] === false) {
				return false;
			}
		}
		return true;
	}
}