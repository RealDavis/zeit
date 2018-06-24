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
import br.com.zeit.utils.FormUtil;
import br.com.zeit.utils.MsgUtil;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNome(request.getParameter("nome").trim());
		usuario.setEmail(request.getParameter("email").trim());
		usuario.setSenha(request.getParameter("senha").trim());
		String senhaConfirmacao = request.getParameter("senhaConfirmar").trim();
		cadastrar(request, response, usuario, senhaConfirmacao);
	}

	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("titulo", "Cadastro de usuário");
		request.getRequestDispatcher("views/usuario/cadastro.jsp").forward(request, response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response, UsuarioDTO usuario,
			String senhaConfirmacao) throws IOException {
		// validação de usuário
		UsuarioValidator validator = new UsuarioValidator();
		String msgErro = validator.validar(usuario, senhaConfirmacao);
		if (!msgErro.isEmpty()) {
			MsgUtil.setErrorMessage(request, msgErro);
			FormUtil.saveObjData(request, usuario);
			response.sendRedirect(request.getContextPath() + "/usuario/cadastro");
		} else {
			//usuário válidado
			UsuarioDAO dao = new UsuarioDAO();
			try {
				if (dao.getByEmail(usuario.getEmail()) != null) {
					MsgUtil.setErrorMessage(request, "Usuário inválido! Escolha outro endereço de email.");
					FormUtil.saveObjData(request, usuario);
					response.sendRedirect(request.getContextPath() + "/usuario/cadastro");
				} else {
					dao.insertUsuario(usuario);
					response.getWriter().println("Usuario cadastrado");
				}
			} catch (PersistenciaException e) {
				response.getWriter().println("Erro no banco de dados");
			} catch (EncriptionException e) {
				response.getWriter().println("Erro interno da aplicação");
			}
		}
	}

}
