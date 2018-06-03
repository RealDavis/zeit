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
		switch (action) {
		case "cadastrousuario":
			UsuarioController.cadastro(request, response);
			break;
		default:
			break;
		}
	}

}
