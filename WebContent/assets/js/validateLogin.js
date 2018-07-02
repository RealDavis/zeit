let email = document.getElementById("email");
let emailClass = email.className;
let erroEmail = document.getElementById("erroEmail");
let emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

let senha = document.getElementById("senha");
let senhaClass = senha.className;
let erroSenha = document.getElementById("erroSenha");

let resultado = [];

email.onchange = () => {
	if(!email.value.match(emailRegex)) {
		email.className = emailClass + " is-invalid";
		erroEmail.innerHTML = "Informe um endereço de email válido";
		resultado[0] = false;
	} else {
		email.className = emailClass + " is-valid";
		erroEmail.inerHTML = "";
		resultado[0] = true;
	}
}

senha.onchange = () => {
	if(senha.value.length < 8) {
		senha.className = senhaClass + " is-invalid";
		erroSenha.innerHTML = "A senha deve ter pelo menos 8 caracteres";
		resultado[1] = false;
	} else {
		senha.className = senhaClass + " is-valid";
		erroSenha.innerHTML = "";
		resultado[1] = true;
	}
}

validaLogin = () => {
	if(email.value === "") {
		email.className = emailClass + " is-invalid";
		erroEmail.innerHTML = "Informe um endereço de email válido";
		resultado[0] = false;
	}
	if(senha.value === "") {
		senha.className = senhaClass + " is-invalid";
		erroSenha.innerHTML = "Informe a senha";
		resultado[1] = false;
	}
	for (var i = 0; i < resultado.length; i++) {
		if(resultado[i] === false) 
			return false;
	}
	return true;
}



















