package br.com.zeit.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.zeit.models.dtos.UsuarioDTO;

public class SessionUtil {

	public static boolean isSessionActive(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		if(sessao.getAttribute("nome") != null && sessao.getAttribute("idUsuario") != null) {
			return true;
		}
		return false;
	}
	
	public static void startSession(HttpServletRequest request, UsuarioDTO usuario) {
		HttpSession sessao = request.getSession();
		sessao.setAttribute("idUsuario", usuario.getIdUsuario());
		sessao.setAttribute("nome", usuario.getNome());
	}
	
	public static void endSession(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		if(isSessionActive(request)) {
			sessao.invalidate();
		}
	}
	
	public static int getSessionId(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		int id = 0;
		if(isSessionActive(request)) {
			id = (Integer) sessao.getAttribute("idUsuario");
		}
		return id;
	}
	
	public static String getSessionName(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		String name = "";
		if(isSessionActive(request)) {
			name = (String) sessao.getAttribute("nome");
		}
		return name;
	}
	
}