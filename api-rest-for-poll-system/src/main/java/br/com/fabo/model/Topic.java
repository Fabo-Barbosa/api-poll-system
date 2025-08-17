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
@Table(name = "topic")
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "content", nullable = false, updatable = false, length = 200)
	private String content;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> votes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<User> getVotes() {
		return votes;
	}
	public void setVotes(List<User> votes) {
		this.votes = votes;
	}
	@Override
	public int hashCode() {
		return Objects.hash(content, id, votes);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		return Objects.equals(content, other.content) && id == other.id && Objects.equals(votes, other.votes);
	}
	
}
