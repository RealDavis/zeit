
let hoje = new Date();

$("#frmTarefa").validate({
	rules: {
		tarefa: {
			required: true,
			minlength: 5,
			maxlength: 200
		},
		data: {
			dateEqualAfter: new Date()
		},
		hora: {
			hourWithoutDate: $("#data"), 
			hourValid: $("#data")
		},
		observacoes: {
			maxlength: 250
		}
	},
	messages: {
		tarefa: {
			required: "Informe a tarefa",
			minlength: "A tarefa deve ter no mínimo 5 caracteres",
			maxlength: "A tarefa deve ter menos de 100 caracteres"
		}, 
		data: {
			dateEqualAfter: "Informe uma data igual ou posterior a data atual"
		},
		hora: {
			hourWithoutDate: "Nenhuma data selecionada",
			hourValid: "Selecione um horário posterior ao atual"
		},
		observacoes: {
			maxlength: "As observações devem ter no máximo 250 caracteres"
		}
	}
});

$(document).ready(function(){
	createDate = (dataString) => {
		let aux = dataString.split("-");
		let d = new Date();
		d.setFullYear(parseInt(aux[0]));
		d.setMonth(parseInt(aux[1]) - 1);
		d.setDate(parseInt(aux[2]));
		
		return d;
	};
	
	equalsDates = (a, b) => {
		if(a.getFullYear() === b.getFullYear()) {
			if(a.getMonth() === b.getMonth()) {
				if(a.getDate() === b.getDate()) {
					return true;
				}
			}
		}
		return false;
	}
	
	jQuery.validator.addMethod("dateEqualAfter", function(value, element, param){
		if(value != "") {
			let d = createDate(value)
			
			return d >= param;
		}
		return true;
	}, 'data menor');
	
	jQuery.validator.addMethod("hourWithoutDate", function(value, element, param){
		if(value != "") {
			if(param.val() === "") {
				param.removeClass("valid");
				param.addClass("error");
				return false;
			} 
			return true;
		}
		return true;
	}, 'Nenhuma data selecionada');
	
	jQuery.validator.addMethod("hourValid", function(value, element, param){
		if(param.val() != "") {
			let hoje = new Date();
			let dataInput = createDate(param.val());
			let aux = value.split(":");
			
			if(dataInput > hoje) {
				return true;
			} else if(equalsDates(dataInput, hoje)){
				if(parseInt(aux[0]) === hoje.getHours()) {
					if(parseInt(aux[1]) < hoje.getMinutes()) {
						return false;
					} else {
						return true;
					}
				} else if(parseInt(aux[0]) > hoje.getHours()){
					return true;
				} else {
					return false;
				}
			}
		}
		return true;
	}, 'Hora inválida');
	
});