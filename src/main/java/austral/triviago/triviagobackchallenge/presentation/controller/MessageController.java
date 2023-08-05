package austral.triviago.triviagobackchallenge.presentation.controller;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;


@Controller
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // The attributes of the message filter should be passed as query parameters
    public Page<Message> getMessages(@ModelAttribute MessageFilter filter, Pageable pageable) {
        return messageService.findAll(filter, pageable);
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable("id") Integer id){
        Optional<Message> m = messageService.findById(id);
        if(m.isPresent()){
            return new ResponseEntity<>(m.get(), HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/messages")
    public ResponseEntity<?> postMessage(@RequestBody Message message){
        return new ResponseEntity<>(messageService.postMessage(message), HttpStatus.ACCEPTED);
    }


}
