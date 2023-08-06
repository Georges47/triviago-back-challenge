package austral.triviago.triviagobackchallenge.presentation.controller;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @GetMapping("/messages")
    public Page<Message> getMessages(@ModelAttribute MessageFilter filter, @RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "size", defaultValue = "10") int size) {
        //Debe recibir el tamaño de las hojas y la hoja en la que se encuentra.
        /* MessageFilter me sirve ya que en el Json se especifica el criterio de matcheo de messages.
        Esto me permite especificar en filter qué campos ya estan llenos. Por ejemplo,
        especificar un campo, como la fecha de creación */
        Pageable pageable= PageRequest.of(page, size);   //"crea" la page con el tamaño dado
        return messageService.findAll(filter, pageable);
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable("id") Integer id){
        //Si m es null, es porque no se encontró
        MessageFilter m = messageService.findById(id);
        if(m != null){
            return new ResponseEntity<>(m, HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>("Message Not Found",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/messages")
    public ResponseEntity<?> postMessage(@RequestBody Message message){
        return new ResponseEntity<>(messageService.postMessage(message), HttpStatus.CREATED);
    }

    @DeleteMapping("/message/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable("id") Integer id){
        //Elimina el message existente, sino "not fonund"
        MessageFilter m = messageService.findById(id);
        if(m != null){
            messageService.deleteMessageById(id);
            return new ResponseEntity<>(m, HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Message Not Found",HttpStatus.NOT_FOUND);
    }




}
