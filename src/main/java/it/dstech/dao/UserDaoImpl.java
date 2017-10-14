package it.dstech.dao;

import java.util.List;

import javax.persistence.Query;

import it.dstech.models.User;

public class UserDaoImpl extends HibernateDao implements UserDao {

	@Override
	public User saveUser(User user) {
		return (User) persist(user);
	}

	@Override
	public User getUserById(int id) {
		return (User) getById(User.class,id);
	}

	@Override
	public User updateUser(User user) {
		update(user);
		return (User) user;
	}

	@Override
	public User deleteUser(int id) {
		return (User) delete(getUserById(id));
	}

	@Override
	public User getUser(String query) {
		return (User) select(query).uniqueResult();
	}

}
