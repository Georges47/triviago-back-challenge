package austral.triviago.triviagobackchallenge.business.impl;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.persistence.repository.MessageRepository;
import austral.triviago.triviagobackchallenge.persistence.specification.MessageSpecification;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MessageServiceImpl implements MessageService {
    final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Page<Message> findAll(MessageFilter filter, Pageable pageable) {
        final MessageSpecification specification = new MessageSpecification(filter);
        // TODO. Pass the specification and pageable to the repository (e.g. messageRepository.findAll(specification, pageable))
        return null;
    }

    @Override
    public Optional<Message> findById(Integer id){
        return messageRepository.findById(id);
    }

    public Message postMessage(Message message){
        return messageRepository.save(message);
    }
}
