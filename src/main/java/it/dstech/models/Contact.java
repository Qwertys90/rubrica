
package it.dstech.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import it.dstech.models.User;

@Entity
public class Contact {
@Id
@GeneratedValue
int ID;

private String nome;

private String telefono;

private String mail;
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="USER_ID")
private User user;

public int getID() {
	return ID;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

}
