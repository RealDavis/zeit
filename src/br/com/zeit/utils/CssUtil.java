package br.com.zeit.utils;

import javax.servlet.http.HttpServletRequest;

public class CssUtil {

	private String css = "";
	private String tagInicio = "<link rel=\"stylesheet\" type=\"text/css\" href=\"/zeit/assets/css/";
	private String tagFinal = ".css\">";
	
	public void addCSS(String newCSS) {
		css += (tagInicio + newCSS + tagFinal + "\n");
	}
	
	public void createCSS(HttpServletRequest request) {
		if(isCSSPersonalizado(request)) {
			String CSSTemp = (String)request.getAttribute("CSSPersonalizado");
			CSSTemp += css;
			request.setAttribute("CSSPersonalizado", CSSTemp);
		} else {
			request.setAttribute("CSSPersonalizado", css);
		}
	}
	
	private boolean isCSSPersonalizado(HttpServletRequest request) {
		return request.getAttribute("CSSPersonalizado") != null;
	}
	
	public static void eraseCSS(HttpServletRequest request) {
		if(request.getAttribute("CSSPersonalizado") != null) {
			request.removeAttribute("CSSPersonalizado");
		}
	}
	
}
