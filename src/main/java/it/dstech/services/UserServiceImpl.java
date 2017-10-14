package it.dstech.services;

import java.util.List;

import javax.persistence.Query;

import it.dstech.dao.UserDao;
import it.dstech.dao.UserDaoImpl;
import it.dstech.models.User;

public class UserServiceImpl implements UserService{

	UserDao dao = new UserDaoImpl();
	
	@Override
	public User saveUser(User user) {
		return dao.saveUser(user);
	}

	@Override
	public User getUserById(int id) {
		return dao.getUserById(id);
	}

	@Override
	public User updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public User deleteUser(int id) {
		return dao.deleteUser(id);
	}

	@Override
	public User getUser(String query) {
		return (User) dao.getUser(query);
	}

	

}
