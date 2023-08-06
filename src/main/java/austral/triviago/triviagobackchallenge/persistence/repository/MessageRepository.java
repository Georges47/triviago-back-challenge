package austral.triviago.triviagobackchallenge.persistence.repository;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//Uso el repositorio para acceder a los mensajes
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>, JpaSpecificationExecutor<Message> {
}
