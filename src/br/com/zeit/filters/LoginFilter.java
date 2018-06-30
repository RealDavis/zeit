package br.com.zeit.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zeit.utils.MsgUtil;
import br.com.zeit.utils.SessionUtil;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = ((HttpServletResponse)response);
		HttpServletRequest req = ((HttpServletRequest)request);
		if(!SessionUtil.isSessionActive(req)) {
			String msgErro = "Ops, parece que você não está logado. \nFaça login para continuar!";
			MsgUtil.setErrorMessage(req, msgErro);
			resp.sendRedirect(req.getContextPath() + "/login");
		} else if(SessionUtil.isSessionActive(req)){
			String uri = req.getRequestURI();
			if((req.getContextPath() + "/usuario/cadastro").equals(uri) || (req.getContextPath() + "/login").equals(uri)) {
				String msgErro = "Você já está logado, não é possível continuar!";
				MsgUtil.setErrorMessage(req, msgErro);
				resp.sendRedirect(req.getContextPath() + "/");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
