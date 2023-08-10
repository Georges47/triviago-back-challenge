package austral.triviago.triviagobackchallenge.business.impl;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.persistence.specification.MessageSpecification;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import austral.triviago.triviagobackchallenge.persistence.repository.messageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private messageRepository messageRepository;

    @Override
    public Page<Message> findAll(MessageFilter filter, Pageable pageable) {
        final MessageSpecification specification = new MessageSpecification(filter);
        return messageRepository.findAll(specification,pageable);
    }

    @Override
    public Message saveMessage(Message message) {
        Message response = new Message();
        message.setCreationDate(LocalDate.now());
        message.setAuthor(message.getAuthor());
        message.setContent(message.getContent());
        return messageRepository.save(response);
    }

    @Override
    public Message delete(Long id) {
        Message message = findById(id);
        messageRepository.delete(message);
        return message;
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }


}


