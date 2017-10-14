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

import it.dstech.dao.HibernateDao;
import it.dstech.models.Contact;
import it.dstech.models.User;
import it.dstech.services.ContactService;
import it.dstech.services.ContactServiceImpl;

@WebServlet("/contact/delete")
public class delete extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	private ContactService contactService= new ContactServiceImpl();
	private static final Logger logger = Logger.getLogger(delete.class.getName());



	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idElimin = req.getParameter("idElimina");
		int id = Integer.parseInt(idElimin);
		
		try {
			contactService.deleteContact(id);
			resp.sendRedirect("listacontatti");
			
			}catch(Exception e) {
				logger.info("record non inserito -> " + e);
				resp.sendRedirect("listacontatti");		
				}
	}
}

