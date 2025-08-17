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
@Table(name = "poll")
public class Poll implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title", nullable = false, updatable = false, length = 45)
	private String title;
	
	@Column(name = "description", length = 120)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Topic> topics;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<User> participants;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, participants, title, topics);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poll other = (Poll) obj;
		return Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(participants, other.participants) && Objects.equals(title, other.title)
				&& Objects.equals(topics, other.topics);
	}

	

}
