package br.com.fabo.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class Login implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="password", nullable = false, length = 20)
	private String password;
	
	@Column(name = "username", nullable = false, unique = true, updatable = false, length = 11)
	private String strUser;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private User user;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStrUser() {
		return strUser;
	}
	public void setStrUser(String strUser) {
		this.strUser = strUser;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, password, strUser, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return id == other.id && Objects.equals(password, other.password) && Objects.equals(strUser, other.strUser)
				&& Objects.equals(user, other.user);
	}

}
