package it.dstech.controller.user;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.Matcher;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.dao.HibernateDao;
import it.dstech.models.User;
import it.dstech.services.UserService;
import it.dstech.services.UserServiceImpl;
import javassist.SerialVersionUID;
import java.util.regex.Pattern;


@WebServlet("/user/registration")
public class Registration extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	public static UserService userService = new UserServiceImpl();
	private static final Logger logger = Logger.getLogger(Login.class.getName());

	@Override
	public void init(ServletConfig config) throws ServletException {
		HibernateDao.getSession();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("../registration.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username= req.getParameter("username");
		logger.info("from jsp Username: " + username);
		String password = req.getParameter("password");
		logger.info("from jsp Password: " + password);
		
		if(validate(username)) {
		try {
		User nuovoUtente = new User();
		nuovoUtente.setPassword(password);
		nuovoUtente.setUsername(username);
		logger.info(nuovoUtente.toString());
		userService.saveUser(nuovoUtente);
		req.getRequestDispatcher("login").forward(req, resp);
		}catch(Exception e) {
		logger.info("from jsprfsdfseg Account esistente" + e);
		req.setAttribute("errore", "Email esistente");
		req.getRequestDispatcher("registration").forward(req, resp);
		
		}
		}else {
			req.setAttribute("errore", "Email non valida");
		req.getRequestDispatcher("registration").forward(req, resp);
		
		}
	}
	public static boolean validate(String emailStr) {
		Pattern regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	    Matcher matcher = regex.matcher(emailStr);
	    return matcher.find();
	}
}
