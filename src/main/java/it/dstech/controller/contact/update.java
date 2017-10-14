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

@WebServlet("/contact/update")
public class update extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	private ContactService contactService= new ContactServiceImpl();
	private static final Logger logger = Logger.getLogger(update.class.getName());



	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HibernateDao.getSession();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("sessionUtente");
		String id= req.getParameter("ID");
		logger.info("from jsp Username: " + id );
		int ids = Integer.parseInt(id);
		String name= req.getParameter("nome");
		logger.info("from jsp Username: " + name );
		String telefono = req.getParameter("telefono");
		logger.info("from jsp Password: " + telefono);
		String mail= req.getParameter("mail");
		logger.info("from jsp Username: " + mail );
		Contact contatto = contactService.getContactById(ids);
		logger.info(user.toString());
		contatto.setNome(name);
		contatto.setTelefono(telefono);
		contatto.setMail(mail);
		contatto.setUser(user);
		try {
		contactService.updateContact(contatto);
		resp.sendRedirect("listacontatti");
		
		}catch(Exception e) {
			logger.info("record non inserito -> " + e);
			resp.sendRedirect("listacontatti");		
			}
	}
}