package austral.triviago.triviagobackchallenge.presentation.mapper;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public ResponseEntity<?> entityToResponseEntity(Message message) {
        if(message!=null){
            return ResponseEntity.ok(message);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el mensaje");
        }
    }
}
