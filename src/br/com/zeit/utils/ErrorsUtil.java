package br.com.zeit.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ErrorsUtil {

	public static boolean isErro(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		return sessao.getAttribute("msgErro") != null;
	}
	
	public static void setMsgErro(HttpServletRequest request, String msgErro) {
		HttpSession sessao = request.getSession();
		sessao.setAttribute("msgErro", msgErro.trim());
	}
	
	public static String getMsgErro(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		return (String)sessao.getAttribute("msgErro");
	}
	
	public static void removeMsgErro(HttpServletRequest request) {
		if(isErro(request)) {
			HttpSession sessao = request.getSession();
			sessao.removeAttribute("msgErro");
		}
	}
	
}