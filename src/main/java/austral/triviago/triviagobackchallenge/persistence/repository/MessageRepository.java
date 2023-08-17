package austral.triviago.triviagobackchallenge.persistence.repository;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MessageRepository extends JpaRepository<Message,Long>, JpaSpecificationExecutor<Message> {


}
