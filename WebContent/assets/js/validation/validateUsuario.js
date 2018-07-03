$("#frmCadastroUsuario").validate({
	rules: {
		nome: {
			required: true,
			minlength: 3,
			maxlength: 128
		},
		email: {
			required: true,
			email: true
		}, 
		senha: {
			required: true, 
			minlength: 8,
			maxlength: 200
		},
		senhaConfirmar: {
			required: true, 
			equalTo: "#senha",
			minlength: 8,
			maxlength: 200
		}
	},
	messages: {
		nome: {
			required: "Informe seu nome",
			minlength: "O nome deve ter no minimo 3 caracteres",
			maxlength: "O nome deve ter no máximo 128 caracteres"
		},
		email: {
			required: "Informe o email",
			email: "Informe um email válido"
		},
		senha: {
			required: "Informe a senha senha",
			minlength: "A senha deve ter entre pelo menos 8 caracteres",
			maxlength: "A senha deve ter menos de 200 caracteres"
		},
		senhaConfirmar: {
			required: "Informe a senha senha",
			equalTo: "A senha deve ser igual a anterior",
			minlength: "A senha deve ter entre pelo menos 8 caracteres",
			maxlength: "A senha deve ter menos de 200 caracteres"
		}
	}
});