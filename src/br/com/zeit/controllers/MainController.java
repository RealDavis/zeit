package br.com.zeit.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = verificaAction(request) ? request.getParameter("action") : null;

		if (action != null) {
			redirect(request, response, action);
		}
	}

	private boolean verificaAction(HttpServletRequest request) {
		return request.getParameter("action") != null;
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String action)
			throws IOException, ServletException {
		UsuarioController usuarioCtr = null;
		LoginController loginCtr = null;
		TarefaController tarefaCtr = null;
		
		switch (action) {
		case "cadastrousuario":
			usuarioCtr = new UsuarioController();
			usuarioCtr.cadastro(request, response);
			break;
		case "login" :
			loginCtr = new LoginController();
			loginCtr.index(request, response);
			break;
		case "index" :
			tarefaCtr = new TarefaController();
			tarefaCtr.index(request, response);
			break;
		case "cadastro" :
			tarefaCtr = new TarefaController();
			tarefaCtr.cadastro(request, response);
			break;
		
		}
	}

}
