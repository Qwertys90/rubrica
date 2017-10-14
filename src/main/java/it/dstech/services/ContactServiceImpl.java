package it.dstech.services;

import java.util.List;

import it.dstech.dao.ContactDao;
import it.dstech.dao.ContactDaoImpl;
import it.dstech.models.Contact;
import it.dstech.models.User;


public class ContactServiceImpl implements ContactService{

	ContactDao dao = new ContactDaoImpl();
	
	@Override
	public Contact saveContact(Contact contact) {
		return dao.saveContact(contact);
	}

	@Override
	public Contact getContactById(int id) {
		return dao.getContactById(id);
	}

	@Override
	public List<Contact> getListContact() {
		return dao.getListContact();
	}

	@Override
	public Contact deleteContact(int id) {
		return dao.deleteContact(id);
	}

	@Override
	public Contact updateContact(Contact contact) {
		return dao.updateContact(contact);
	}
	public List<Contact> getContact(User user) {
		return (List<Contact>) dao.getContact(user);
	}

}
