package it.dstech.controller.user;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.dao.HibernateDao;
import it.dstech.models.User;
import it.dstech.services.UserService;
import it.dstech.services.UserServiceImpl;

@WebServlet("/user/login")
public class Login extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	private UserService userService= new UserServiceImpl();
	private static final Logger logger = Logger.getLogger(Login.class.getName());
	private User utente;

	@Override
	public void init(ServletConfig config) throws ServletException {
		HibernateDao.getSession();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("../index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username= req.getParameter("username");
		logger.info("from jsp Username: " + username);
		String password = req.getParameter("password");
		logger.info("from jsp Password: " + password);
		String query = "Select a FROM User a WHERE a.username='" + username + "' AND a.password='" + password + "'";
		
		
		try {
			utente = userService.getUser(query);
		}catch(Exception e) {
			logger.info("errore" + e);
			resp.sendRedirect("error.jsp");
			
		}
		logger.info("utente " + utente);
		if(utente!=null) {
		logger.info("Accesso con " + username + " " + password);
		HttpSession session = req.getSession();
		session.setAttribute("sessionUtente", utente);
		resp.sendRedirect("../contact/listacontatti");

	    }else {
	    	resp.sendRedirect("login");
	    }
}
}
