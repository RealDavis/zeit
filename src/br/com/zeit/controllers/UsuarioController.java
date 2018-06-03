package br.com.zeit.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zeit.exceptions.EncriptionException;
import br.com.zeit.exceptions.PersistenciaException;
import br.com.zeit.models.daos.UsuarioDAO;
import br.com.zeit.models.dtos.UsuarioDTO;
import br.com.zeit.models.validators.UsuarioValidator;
import br.com.zeit.utils.ErrorsUtil;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("cadastrar")) {
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setNome(request.getParameter("nome").trim());
			usuario.setEmail(request.getParameter("email").trim());
			usuario.setSenha(request.getParameter("senha").trim());
			String senhaConfirmacao = request.getParameter("senhaConfirmar").trim();
			cadastrar(request, response, usuario, senhaConfirmacao);
		} else {
			response.getWriter().println("Outra a��o");
		}
	}
	
	protected static void cadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("titulo", "Cadastro de usu�rio");
		request.getRequestDispatcher("views/views-usuario/cadastro.jsp").forward(request, response);
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response, UsuarioDTO usuario,
			String senhaConfirmacao) throws IOException {
		//valida��o de usu�rio
		UsuarioValidator validator = new UsuarioValidator();
		String msgErro = validator.validar(usuario, senhaConfirmacao);
		if(!msgErro.isEmpty()) {
			ErrorsUtil.setMsgErro(request, msgErro);
			ErrorsUtil.saveObjData(request, usuario);
			response.sendRedirect("cadastro");
		} 
		
		UsuarioDAO dao = new UsuarioDAO();
		try {
			if(dao.getByEmail(usuario.getEmail()) != null) {
				ErrorsUtil.setMsgErro(request, "Usu�rio inv�lido!");
				ErrorsUtil.saveObjData(request, usuario);
				response.sendRedirect("cadastro");
			} else {
				dao.insertUsuario(usuario);
				response.getWriter().println("Usuario cadastrado");	
			}
		} catch (PersistenciaException e) {
			response.getWriter().println("Erro no banco de dados");	
		} catch (EncriptionException e) {
			response.getWriter().println("Erro interno da aplica��o");	
		}
	}

}
