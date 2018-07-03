$("#frmLogin").validate({
	rules: {
		email: {
			required: true,
			email: true
		}, 
		senha: {
			required: true, 
			minlength: 8,
			maxlength: 200
		}
	},
	messages: {
		email: {
			required: "Informe o email",
			email: "Informe um email válido"
		},
		senha: {
			required: "Informe a senha senha",
			minlength: "A senha deve ter entre pelo menos 8 caracteres",
			maxlength: "A senha deve ter menos de 200 caracteres"
		}
	}
});