package austral.triviago.triviagobackchallenge.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import austral.triviago.triviagobackchallenge.persistence.domain.Message;


public interface MessageRepository extends JpaRepository<Message, Long>, JpaSpecificationExecutor<Message> {
    
    

}
