package br.com.fabo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private Long id;
	
	@Column(name = "title", nullable = false, updatable = false, length = 45)
	private String title;
	
	@Column(name = "description", length = 120)
	private String description;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Topic> topics;

	// Data de criação da enquete
	// Data de encerramento da enquete
	// Data de ínicio da enquete
	// Status da enquete (ENUM)
	
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

	@Override
	public int hashCode() {
		return Objects.hash(description, id, title, topics);
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
				&& Objects.equals(title, other.title)
				&& Objects.equals(topics, other.topics);
	}

	

}
