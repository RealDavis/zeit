package br.com.zeit.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zeit.exceptions.PersistenciaException;
import br.com.zeit.models.daos.TarefaDAO;
import br.com.zeit.models.dtos.TarefaDTO;
import br.com.zeit.models.validators.TarefaValidator;
import br.com.zeit.utils.DateHourUtil;
import br.com.zeit.utils.FormUtil;
import br.com.zeit.utils.MsgUtil;
import br.com.zeit.utils.SessionUtil;

@WebServlet("/tarefa")
public class TarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().println("Página inicial tarefas");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TarefaDTO tarefa = new TarefaDTO();
		int teste = 0;
		tarefa.setTarefa(request.getParameter("tarefa").trim());
		tarefa.setData(DateHourUtil.strToDBFormat(request.getParameter("data")));
		tarefa.setHora(DateHourUtil.strToHour(request.getParameter("hora")));
		tarefa.setObservacoes(request.getParameter("observacoes"));
		tarefa.setConcluido(false);
		tarefa.setIdUsuario(SessionUtil.getSessionId(request));
		cadastrar(request, response, tarefa);
	}
	
	protected void cadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("titulo", "Cadastrar tarefa");
		request.getRequestDispatcher("views/tarefa/cadastro.jsp").forward(request, response);
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response, TarefaDTO tarefa) throws IOException {
		TarefaValidator validator = new TarefaValidator();
		String msgErro = validator.validar(tarefa);
		if(!msgErro.isEmpty()) {
			MsgUtil.setErrorMessage(request, msgErro);
			FormUtil.saveObjData(request, tarefa);
			response.sendRedirect("cadastro");
		} else {
			TarefaDAO dao = new TarefaDAO();
			try {
				if(dao.insert(tarefa)) {
					String msgSucess = "Tarefa salva com sucesso!";
					MsgUtil.setSuccessMessage(request, msgSucess);
					response.sendRedirect("cadastro");
				}
			} catch(PersistenciaException e) {
				response.getWriter().println(e.getMessage());
			}
		}
	}

}
