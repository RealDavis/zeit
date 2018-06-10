package br.com.zeit.models.validators;

import br.com.zeit.models.dtos.UsuarioDTO;

public class UsuarioValidator{

	private StringBuilder msgErro = new StringBuilder();
	private String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public String validarLogin(UsuarioDTO usuario) {
		validarEmail(usuario.getEmail());
		validarSenha(usuario.getSenha());
		return msgErro.toString().trim();
	}
	
	public String validar(UsuarioDTO usuario, String senhaConfirmar) {
		validarNome(usuario.getNome());
		validarEmail(usuario.getEmail());
		validarSenhas(usuario.getSenha(), senhaConfirmar);
		return msgErro.toString().trim();
	}
	
	private void validarNome(String nome) {
		if(nome == null || nome.isEmpty()) {
			msgErro.append("Preencha o campo nome.<br>\n");
		} else if(nome.length() < 5) {
			msgErro.append("Nome inválido. O nome deve ter no minimo 5 caracteres.<br>\n");
		}
	}

	private void validarEmail(String email) {
		if(email == null || email.isEmpty()) {
			msgErro.append("Preencha o campo email.<br>\n");
		} else if(!email.matches(emailRegex)) {
			msgErro.append("Email inválido. Confira o email informado<br>\n");
		}
	}
	
	private void validarSenha(String senha) {
		if(senha == null || senha.isEmpty()) {
			msgErro.append("Preencha o campo de senha.<br>\n");
		}  else if(senha.length() < 8) {
			msgErro.append("A senha deve ter no minimo 8 caracteres.<br>\n");
		}
	}
	
	private void validarSenhas(String senhaA, String senhaB) {
		if(senhaA == null || senhaB == null || senhaA.isEmpty() || senhaB.isEmpty()) {
			msgErro.append("Preencha todos os campos de senha.<br>\n");
		} else if (!senhaA.equals(senhaB)) {
			msgErro.append("Preencha os campos de senha com senhas iguais.<br>\n");
		} else if(senhaA.length() < 8) {
			msgErro.append("A senha deve ter no minimo 8 caracteres.<br>\n");
		}
	}

}
