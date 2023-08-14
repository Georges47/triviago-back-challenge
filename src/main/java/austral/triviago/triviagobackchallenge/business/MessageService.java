package austral.triviago.triviagobackchallenge.business;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService{
    Page<Message> findAll(MessageFilter messageFilter, Pageable pageable);

    Message findById(Long id);

    Message saveMessage(Message message);

    Message delete(Long id);
}
