package austral.triviago.triviagobackchallenge.business.impl;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.persistence.repository.MessageRepository;
import austral.triviago.triviagobackchallenge.persistence.specification.MessageSpecification;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
        
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Page<Message> findAll(MessageFilter filter, Pageable pageable) {
        final MessageSpecification specification = new MessageSpecification(filter);
        return messageRepository.findAll(specification, pageable);
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
    }

    @Override
    public Message saveMessage(String author, String content) {
        Message message = new Message();
        message.setAuthor(author);
        message.setDate( LocalDate.now() );
        message.setContent(content);
        return messageRepository.save(message);
    }

    @Override
    public Message delete(Long id) {
        Message message = findById(id);
        messageRepository.delete(message);
        return message;
    }
}
