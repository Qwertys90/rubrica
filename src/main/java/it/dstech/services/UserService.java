package it.dstech.services;

import java.util.List;

import javax.persistence.Query;

import it.dstech.models.User;

public interface UserService {

	User saveUser(User user);

	User getUserById(int id);

	User updateUser(User user);

	User deleteUser(int id);
	
	User getUser(String query);

}
