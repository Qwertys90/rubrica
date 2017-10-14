package it.dstech.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	
@Id
@GeneratedValue
private int ID;

private String username;
 
private String password;

@OneToMany(mappedBy="user")
private List<Contact> listaContatti;



public User() {
	this.listaContatti = new ArrayList();
}

public int getID() {
	return ID;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public List<Contact> getListaContatti() {
	return listaContatti;
}

public void setListaContatti(List<Contact> listaContatti) {
	this.listaContatti = listaContatti;
}

@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + "]";
}


}
