package austral.triviago.triviagobackchallenge.business;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MessageService {
    List<Message> findAll(MessageFilter messageFilter, Pageable pageable);
}
