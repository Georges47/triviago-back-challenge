package austral.triviago.triviagobackchallenge.presentation.controller;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // The attributes of the message filter should be passed as query parameters
    public List<Message> getMessages(@ModelAttribute MessageFilter filter, Pageable pageable) {
        return messageService.findAll(filter, pageable);
    }
}
