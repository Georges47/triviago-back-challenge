package austral.triviago.triviagobackchallenge.business;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MessageService {
    Page<Message> findAll(MessageFilter messageFilter, Pageable pageable);

    Message saveMessage(Message message);

    Message delete(Long id);

    Message findById(Long id);
}
