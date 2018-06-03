package br.com.zeit.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zeit.models.dtos.UsuarioDTO;
import br.com.zeit.models.validators.UsuarioValidator;
import br.com.zeit.utils.ErrorsUtil;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNome(request.getParameter("nome").trim());
		usuario.setEmail(request.getParameter("email").trim());
		usuario.setSenha(request.getParameter("senha").trim());
		String senhaConfirmacao = request.getParameter("senhaConfirmar").trim();
		
		//validação de usuário
		UsuarioValidator validator = new UsuarioValidator();
		String msgErro = validator.validar(usuario, senhaConfirmacao);
		if(!msgErro.isEmpty()) {
			ErrorsUtil.setMsgErro(request, msgErro);
			response.sendRedirect("cadastro");
		} 
		
		response.getWriter().println("Usuario válido");
	}
	
	protected static void cadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("titulo", "Cadastro de usuário");
		request.getRequestDispatcher("views/views-usuario/cadastro.jsp").forward(request, response);
	}

}
