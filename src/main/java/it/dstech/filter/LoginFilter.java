package it.dstech.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.models.User;

@WebFilter("/contact/*")
public class LoginFilter implements Filter{
	
	
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse res = (HttpServletResponse) response;
	HttpSession session = req.getSession();
	String loginURI = req.getContextPath() + "/user/login";
	User user=(User) session.getAttribute("sessionUtente");
	if(user!=null)
		chain.doFilter(req, res);
	else
		res.sendRedirect(loginURI);
	
}

@Override
public void init(FilterConfig filterConfig) throws ServletException {
	
	
}

@Override
public void destroy() {
	
	
}
}
