package austral.triviago.triviagobackchallenge.persistence.repository;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface messageRepository extends JpaRepository<Message, Long> , JpaSpecificationExecutor<Message> {

}
