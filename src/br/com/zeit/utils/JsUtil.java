package br.com.zeit.utils;

import javax.servlet.http.HttpServletRequest;

public class JsUtil {
	
	private String js = "";
	private String tagInicio = "<script type=\"text/javascript\" src=\"/zeit/assets/js/";
	private String tagFinal = ".js\"></script>";
	
	public void addJs(String newJs) {
		js += (tagInicio + newJs + tagFinal + "\n");
	}
	
	public void createJs(HttpServletRequest request) {
		if(isJsPersonalizado(request)) {
			String jsTemp = (String)request.getAttribute("jsPersonalizado");
			jsTemp += js;
			request.setAttribute("jsPersonalizado", jsTemp);
		} else {
			request.setAttribute("jsPersonalizado", js);
		}
	}
	
	private boolean isJsPersonalizado(HttpServletRequest request) {
		return request.getAttribute("jsPersonalizado") != null;
	}
	
	public static void eraseJs(HttpServletRequest request) {
		if(request.getAttribute("jsPersonalizado") != null) {
			request.removeAttribute("jsPersonalizado");
		}
	}
	
}