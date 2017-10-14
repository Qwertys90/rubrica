package it.dstech.dao;

import java.util.List;

import javax.persistence.Query;

import it.dstech.models.User;

public interface UserDao {

	User saveUser(User user);

	User getUserById(int id);
	
	User getUser(String query);

	User updateUser(User user);

	User deleteUser(int id);

}
