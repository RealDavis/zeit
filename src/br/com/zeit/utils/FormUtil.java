package br.com.zeit.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.zeit.interfaces.IDTO;

public class FormUtil {

	public static void saveObjData(HttpServletRequest request, IDTO dto) {
		HttpSession sessao = request.getSession();
		sessao.setAttribute("entidade", dto);
	}

	public static void removeObjData(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("entidade") != null) {
			sessao.removeAttribute("entidade");
		}
	}
	
}
