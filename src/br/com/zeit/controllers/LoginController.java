package br.com.zeit.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jestoque.security.Encript;
import br.com.zeit.exceptions.EncriptionException;
import br.com.zeit.exceptions.PersistenciaException;
import br.com.zeit.models.daos.LoginDAO;
import br.com.zeit.models.daos.UsuarioDAO;
import br.com.zeit.models.dtos.UsuarioDTO;
import br.com.zeit.models.validators.UsuarioValidator;
import br.com.zeit.utils.FormUtil;
import br.com.zeit.utils.MsgUtil;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setEmail(request.getParameter("email").trim());
		usuario.setSenha(request.getParameter("senha").trim());
		login(request, response, usuario);
	}
	
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("titulo", "Login");
		request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response, UsuarioDTO usuario) throws IOException {
		//valida��o de usu�rio
		UsuarioValidator validator = new UsuarioValidator();
		String msgErro = validator.validarLogin(usuario);
		if (!msgErro.isEmpty()) {
			MsgUtil.setErrorMessage(request, msgErro);
			FormUtil.saveObjData(request, usuario);
			response.sendRedirect("login");
		} else {
			//usuario validado
			LoginDAO dao = new LoginDAO();
			Encript encriptor = new Encript();
			try {
				usuario.setSenha(encriptor.encriptPassword(usuario.getSenha()));
				UsuarioDTO usuarioValidado = dao.validarUsuario(usuario);
				if(usuarioValidado != null) {
					response.getWriter().println("Usuario logado");
				} else {
					MsgUtil.setErrorMessage(request, "Usuario n�o encontrado. Verifique os dados informados.");
					response.sendRedirect("login");
				}
			} catch (PersistenciaException e) {
				response.getWriter().println(e.getMessage() + " " + e.getCause());
			} catch (EncriptionException e) {
				response.getWriter().println(e.getMessage());
			}
		}
		
	}

}
