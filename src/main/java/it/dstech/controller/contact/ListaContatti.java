package it.dstech.controller.contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.controller.user.Login;
import it.dstech.dao.HibernateDao;
import it.dstech.models.Contact;
import it.dstech.models.User;
import it.dstech.services.ContactService;
import it.dstech.services.ContactServiceImpl;
import it.dstech.services.UserService;
import it.dstech.services.UserServiceImpl;

@WebServlet("/contact/listacontatti")
public class ListaContatti extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	private UserService userService= new UserServiceImpl();
	private ContactService contactService= new ContactServiceImpl();

	private static final Logger logger = Logger.getLogger(Login.class.getName());



	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("sessionUtente");
		logger.info(user.toString());
		logger.info(user.getID() + "ID");
//		String query = "select a.listaContatti FROM User a WHERE a.ID="+user.getID();
//		logger.info(query);
//		List<Contact> listaContatti = (List<Contact>) contactService.getContact(query);
		List<Contact> listaContatti = (List<Contact>) contactService.getContact(user);
		
		req.setAttribute("contactLis", listaContatti);
		req.getRequestDispatcher("../listacontatti.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
}

