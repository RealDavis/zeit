package br.com.zeit.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import br.com.zeit.exceptions.PersistenciaException;
import br.com.zeit.filters.LoginFilter;
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
	
	protected void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("titulo", "Inicio");
		request.getRequestDispatcher("views/tarefa/index.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TarefaDTO tarefa = new TarefaDTO();
		tarefa.setTarefa(request.getParameter("tarefa").trim());
		tarefa.setData(!request.getParameter("data").isEmpty() ? LocalDate.parse(request.getParameter("data")) : null);
		tarefa.setHora(!request.getParameter("hora").isEmpty() ? LocalTime.parse(request.getParameter("hora")) : null);
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
					response.sendRedirect(request.getContextPath() + "/");
				}
			} catch(PersistenciaException e) {
				response.getWriter().println(e.getMessage());
			}
		}
	}
	
	protected void concluir(HttpServletRequest request, HttpServletResponse response,int idTarefa) throws IOException {
		TarefaDAO dao = new TarefaDAO();
		try {
			if(dao.concluir(idTarefa)) {
				String msgSucess = "Tarefa concluída!";
				MsgUtil.setSuccessMessage(request, msgSucess);
				response.sendRedirect(request.getContextPath() + "/");
			} else {
				response.getWriter().println("Erro");
			}
		} catch (PersistenciaException e) {
			response.getWriter().println(e.getMessage());
		}
	}

	public void excluir(HttpServletRequest request, HttpServletResponse response, int idTarefa) throws IOException {
		TarefaDAO dao = new TarefaDAO();
		try {
			if(dao.excluir(idTarefa)) {
				String msgSucess = "Exclusão realizada com sucesso!";
				MsgUtil.setSuccessMessage(request, msgSucess);
				response.sendRedirect(request.getContextPath() + "/");
			}
		} catch (PersistenciaException e) {
			response.getWriter().println(e.getMessage());
		}
	}

	public void edicao(HttpServletRequest request, HttpServletResponse response, int idTarefa) throws IOException, ServletException {
		TarefaDAO dao = new TarefaDAO();
		try {
			TarefaDTO tarefa = dao.getById(idTarefa);
			if(tarefa != null) {
				FormUtil.saveObjData(request, tarefa);
				request.setAttribute("titulo", "Editar tarefa");
				request.setAttribute("idTarefa", idTarefa);
				response.getWriter().println(tarefa);
				request.getRequestDispatcher("views/tarefa/editar.jsp").forward(request, response);
			} else {
				response.getWriter().println(tarefa);
			}
		} catch (PersistenciaException e) {
			response.getWriter().println(e.getMessage());
		}
	}

	public void editar(HttpServletRequest request, HttpServletResponse response, int idTarefa) throws IOException {
		TarefaDTO tarefa = new TarefaDTO();
		tarefa.setIdTarefa(idTarefa);
		tarefa.setTarefa(request.getParameter("tarefa").trim());
		tarefa.setData(!request.getParameter("data").isEmpty() ? LocalDate.parse(request.getParameter("data")) : null);
		tarefa.setHora(!request.getParameter("hora").isEmpty() ? LocalTime.parse(request.getParameter("hora")) : null);
		tarefa.setObservacoes(request.getParameter("observacoes"));
		
		TarefaValidator validator = new TarefaValidator();
		String msgErro = validator.validar(tarefa);
		if(!msgErro.isEmpty()) {
			MsgUtil.setErrorMessage(request, msgErro);
			FormUtil.saveObjData(request, tarefa);
			response.sendRedirect(request.getContextPath() + "/tarefas/edicao/" + idTarefa);
		} else {
			TarefaDAO dao = new TarefaDAO();
			try {
				if(dao.update(tarefa)) {
					String msgSucess = "Edição realizada com sucesso!";
					MsgUtil.setSuccessMessage(request, msgSucess);
					response.sendRedirect(request.getContextPath() + "/");
				}
			} catch(PersistenciaException e) {
				response.getWriter().println(e.getMessage());
			}
		}
	}

}
