package austral.triviago.triviagobackchallenge.presentation.controller;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public Message createMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    // The attributes of the message filter should be passed as query parameters
    @GetMapping("/messages")
    public Page<Message> getMessages(@ModelAttribute MessageFilter filter, Pageable pageable) {
        return messageService.findAll(filter, pageable);
    }

    @GetMapping("/messages/{id}")
    public Message getMessage(@PathVariable Long id) {
        return messageService.findById(id);
    }

    @DeleteMapping("/messages/{id}")
    public Message deleteMessage(@PathVariable Long id) {
        return messageService.delete(id);
    }

}
