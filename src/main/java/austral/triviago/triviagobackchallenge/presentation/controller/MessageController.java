package austral.triviago.triviagobackchallenge.presentation.controller;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.business.impl.MessageServiceImpl;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    // The attributes of the message filter should be passed as query parameters
    @GetMapping("/messages")
    public Page<Message> getMessages(@ModelAttribute MessageFilter filter, Pageable pageable) {
        return messageService.findAll(filter, pageable);
    }
    @GetMapping("/messages/{id}")
    public Message getMessageById(@PathVariable Long id){
        return messageService.findById(id);
    }

    @PostMapping("/messages")
    public Message createMessage(@RequestBody Message message){
        message.setCreation_date();
        return messageService.save(message);
    }

    @DeleteMapping("/messages/{id}")
    public Message deleteMessage(@PathVariable Long id){
        return messageService.delete(id);
    }
}
