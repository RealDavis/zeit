let nome = document.getElementById("nome");
let nomeClass = nome.className;
let erroNome = document.getElementById("erroNome");

let email = document.getElementById("email");
let emailClass = email.className;
let erroEmail = document.getElementById("erroEmail");
let emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

let senha = document.getElementById("senha");
let senhaClass = senha.className;
let erroSenha = document.getElementById("erroSenha");

let senhaConfirmar = document.getElementById("senhaConfirmar");
let senhaConfirmarClass = senhaConfirmar.className;
let erroSenhaConfirmar = document.getElementById("erroSenhaConfirmar");

let resultado = [];

nome.onchange = () => {
	if(nome.value.length < 3 || nome.value.length > 128) {
		nome.className = nomeClass + " is-invalid";
		erroNome.innerHTML = "O nome deve ter entre 3 e 128 caracteres";
		resultado[0] = false;
	} else {
		nome.className = nomeClass + " is-valid";
		erroNome.innerHTML = "";
		resultado[0] = true;
	}
}

email.onchange = () => {
	if(!email.value.match(emailRegex)) {
		email.className = emailClass + " is-invalid";
		erroEmail.innerHTML = "Informe um endereço de email válido";
		resultado[1] = false;
	} else {
		email.className = emailClass + " is-valid";
		erroEmail.inerHTML = "";
		resultado[1] = true;
	}
}

senha.onchange = () => {
	if(senha.value.length < 8) {
		senha.className = senhaClass + " is-invalid";
		erroSenha.innerHTML = "A senha deve ter pelo menos 8 caracteres";
		resultado[2] = false;
	} else {
		senha.className = senhaClass + " is-valid";
		erroSenha.innerHTML = "";
		resultado[2] = true;
	}
}

senhaConfirmar.onchange = () => {
	if(senhaConfirmar.value === "") {
		senhaConfirmar.className = senhaConfirmarClass + " is-invalid";
		erroSenhaConfirmar.innerHTML = "Informe a senha novamente";
		resultado[3] = false;
	} else if(senhaConfirmar.value !== senha.value) {
		senhaConfirmar.className = senhaConfirmarClass + " is-invalid";
		erroSenhaConfirmar.innerHTML = "As senhas devem ser iguais";
		resultado[3] = false;
	} else {
		senhaConfirmar.className = senhaClass + " is-valid";
		erroSenhaConfirmar.innerHTML = "";
		resultado[3] = true;
	}
	
}

validarUsuario = () => {
	if(nome.value === "") {
		nome.className = nomeClass + " is-invalid";
		erroNome.innerHTML = "Informe um nome";
		resultado[0] = false;
	}
	if(email.value === "") {
		email.className = emailClass + " is-invalid";
		erroEmail.innerHTML = "Informe um endereço de email";
		resultado[1] = false;
	}
	if(senha.value === "" && senhaConfirmar.value === "") {
		senha.className = senhaClass + " is-invalid";
		erroSenha.innerHTML = "Informe uma senha";
		senhaConfirmar.className = senhaConfirmarClass + " is-invalid";
		erroSenhaConfirmar.innerHTML = "As senhas devem ser iguais";
		resultado[2] = false;
		resultado[3] = false;
	} else if(senha.value.length > 8 && senhaConfirmar.value === "") {
		senhaConfirmar.className = senhaConfirmarClass + " is-invalid";
		erroSenhaConfirmar.innerHTML = "Repita a senha";
		resultado[3] = false;
	}
	
	for(let i = 0; i < resultado.length; i++) {
		if(resultado[i] === false)
			return false;
	}
	return true;
}