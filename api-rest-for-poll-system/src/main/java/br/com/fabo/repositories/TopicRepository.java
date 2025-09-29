package br.com.fabo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabo.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
