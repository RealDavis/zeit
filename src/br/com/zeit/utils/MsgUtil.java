package br.com.zeit.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.zeit.interfaces.IDTO;

public class MsgUtil {

	//mensagens opcionais
	public static boolean isMessage(HttpServletRequest request, String msgName) {
		HttpSession sessao = request.getSession();
		return sessao.getAttribute(msgName) != null;
	}

	public static void setMessage(HttpServletRequest request, String msgName, String msg) {
		HttpSession sessao = request.getSession();
		if(msgName != null && !msgName.isEmpty() && msg != null && !msg.isEmpty()) {
			sessao.setAttribute(msgName, msg.trim());
		}
	}

	public static String getMessage(HttpServletRequest request, String msgName) {
		HttpSession sessao = request.getSession();
		if(msgName != null && !msgName.isEmpty()) {
			return (String) sessao.getAttribute(msgName);
		}
		return null;
	}
	
	public static void removeMessage(HttpServletRequest request, String msgName) {
		if (isMessage(request, msgName)) {
			HttpSession sessao = request.getSession();
			sessao.removeAttribute(msgName);
		}
	}
	
	//mensagens de sucesso
	public static boolean isSuccessMessage(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		return sessao.getAttribute("successMessage") != null;
	}

	public static void setSuccessMessage(HttpServletRequest request, String msg) {
		HttpSession sessao = request.getSession();
		if(msg != null && !msg.isEmpty()) {
			sessao.setAttribute("successMessage", msg.trim());
		}
	}

	public static String getSuccessMessage(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		if(isSuccessMessage(request)) {
			String mensagem = (String)sessao.getAttribute("successMessage");
			removeSuccessMessage(request);
			return mensagem;
		}
		return null;
	}
	
	public static void removeSuccessMessage(HttpServletRequest request) {
		if (isSuccessMessage(request)) {
			HttpSession sessao = request.getSession();
			sessao.removeAttribute("successMessage");
		}
	}
	
	//mensagens de erro
	public static boolean isErrorMessage(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		return sessao.getAttribute("errorMessage") != null;
	}

	public static void setErrorMessage(HttpServletRequest request, String msg) {
		HttpSession sessao = request.getSession();
		if(msg != null && !msg.isEmpty()) {
			sessao.setAttribute("errorMessage", msg.trim());
		}
	}

	public static String getErrorMessage(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		if(isErrorMessage(request)) {
			String mensagem = (String)sessao.getAttribute("errorMessage");
			removeErrorMessage(request);
			return mensagem;
		}
		return null;
	}
	
	public static void removeErrorMessage(HttpServletRequest request) {
		if (isErrorMessage(request)) {
			HttpSession sessao = request.getSession();
			sessao.removeAttribute("errorMessage");
		}
	}
	
}