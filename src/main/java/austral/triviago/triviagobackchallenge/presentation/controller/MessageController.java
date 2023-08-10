package austral.triviago.triviagobackchallenge.presentation.controller;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.persistence.specification.MessageSpecification;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import austral.triviago.triviagobackchallenge.presentation.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private final MessageService messageService;

    private final  MessageMapper messageMapper;



    public MessageController(MessageService messageService, MessageMapper messageMapper) {
        this.messageService = messageService;
        this.messageMapper = messageMapper;
    }

    // The attributes of the message filter should be passed as query parameters
    public Page<Message> getMessages(@ModelAttribute MessageFilter filter, Pageable pageable) {
        return messageService.findAll(filter, pageable);
    }


    @PostMapping()
    public Message createMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    @DeleteMapping("/{id}")
    public Message deleteMessage(@PathVariable Long id) {
        return messageService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMessage(@PathVariable Long id) {
        return messageMapper.entityToResponseEntity(messageService.findById(id));
    }


    @GetMapping("/messages")
    public Page<Message> getFilteredMessages(@ModelAttribute MessageFilter filter, Pageable pageable) {
        return messageService.findAll(filter,pageable);
    }

}
