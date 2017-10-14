package it.dstech.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import it.dstech.models.Contact;
import it.dstech.models.User;

public class ContactDaoImpl extends HibernateDao implements ContactDao{

	@Override
	public Contact saveContact(Contact contact) {
		return (Contact) persist(contact);
	}

	@Override
	public Contact getContactById(int id) {
		return (Contact) getById(Contact.class,id);
	}

	@Override
	public List<Contact> getListContact() {
		return select("Select a FROM a").list();
		
	}

	@Override
	public List<Contact> getContact(User user) {
//		return (List<Contact>) select(query).list();
		Criteria cr = getSession().createCriteria(Contact.class, "contact");
		cr.createAlias("contact.user", "user");
		cr.add(Restrictions.eq("user.ID", user.getID()));
		List<Contact> results = (List<Contact>) cr.list();
		return results;
	}

	@Override
	public Contact updateContact(Contact contact) {
		update(contact);
		return (Contact) contact;
	}

	@Override
	public Contact deleteContact(int id) {
		return (Contact) delete(getContactById(id));
	}

}
