package austral.triviago.triviagobackchallenge.presentation.controller;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.persistence.specification.MessageSpecification;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MessageController {

    @Autowired
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // The attributes of the message filter should be passed as query parameters
    public Page<Message> getMessages(@ModelAttribute MessageFilter filter, Pageable pageable) {
        return messageService.findAll(filter, pageable);
    }


    @PostMapping("/messages")
    public Message createMessage(@RequestBody Message message) {
        return messageService.saveMessage(message.getAuthor(),message.getContent());
    }

    @DeleteMapping("/messages/{id}")
    public Message deleteMessage(@PathVariable Long id) {
        return messageService.delete(id);
    }

    @GetMapping("/message/{id}")
    public Message getMessage(@PathVariable Long id) {
        return messageService.findById(id);
    }


    @GetMapping("/messages")
    public Page<Message> getFilteredMessages(@ModelAttribute MessageFilter filter, Pageable pageable) {
        return messageService.findAll(filter,pageable);
    }

}
