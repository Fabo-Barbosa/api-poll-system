package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabo.model.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

}
