package austral.triviago.triviagobackchallenge.business.impl;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.persistence.exception.NotFoundException;
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
        return messageRepository.findById(id).orElseThrow(() -> new NotFoundException("Message not found with id: " + id));
    }

    @Override
    public Message saveMessage(Message m) {
        Message message = new Message();
        message.setAuthor(m.getAuthor());
        message.setDate(LocalDate.now());
        message.setContent(m.getContent());
        return messageRepository.save(message);
    }

    @Override
    public Message delete(Long id) {
        Message message = messageRepository.findById(id).orElseThrow(() -> new NotFoundException("Message not found with id: " + id));
        messageRepository.delete(message);
        return message;
    }
}
