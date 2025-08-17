package br.com.fabo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false, length = 80)
	private String name;
	
	@Column(name = "address", nullable = false, length = 50)
	private String address;
	
	@Column(name = "gender", length = 5)
	private String gender;
	
	@Column(name = "cpf", nullable = false, unique = true, length = 11)
	private String cpf;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Poll> polls;

	public User() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Poll> getPolls() {
		return polls;
	}

	public void setPolls(List<Poll> polls) {
		this.polls = polls;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cpf, gender, id, name, polls);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(polls, other.polls);
	}
	
	

}
