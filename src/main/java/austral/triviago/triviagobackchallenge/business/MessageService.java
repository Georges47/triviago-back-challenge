package austral.triviago.triviagobackchallenge.business;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    Page<Message> findAll(MessageFilter messageFilter, Pageable pageable);

    Message findById(Long id);

    Message save(Message message);

    Message delete(Long id);
}
