package austral.triviago.triviagobackchallenge.business.impl;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.persistence.repository.MessageRepository;
import austral.triviago.triviagobackchallenge.persistence.specification.MessageSpecification;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MessageServiceImpl implements MessageService {
    final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Page<Message> findAll(MessageFilter filter, Pageable pageable) {
        final MessageSpecification specification = new MessageSpecification(filter); //Especificación
        // TODO. Pass the specification and pageable to the repository (e.g. messageRepository.findAll(specification, pageable))
        List<Message> messages = messageRepository.findAll(specification);

        int pageSize = pageable.getPageSize(); //tamaño de cada pagina
        int currentPage = pageable.getPageNumber(); //numero de pagina actual
        int startItem = currentPage * pageSize; //indica la posición del primer elemento de esa pagina

        List<Message> pageMessages;

        if (messages.size() < startItem) {
            pageMessages = List.of(); //Por si no hay suficientes elementos para llenar esa página
        } else {
            int toIndex = Math.min(startItem + pageSize, messages.size());
            pageMessages = messages.subList(startItem, toIndex); //Si es menor, crea la sublista
        }

        return new PageImpl<>(pageMessages, pageable, messages.size());
    }

    @Override
    public MessageFilter findById(Integer id){
        //Si lo encuentra, retorna la dto del message
        Optional<Message> m = messageRepository.findById(id);
        if(m.isPresent()){
            MessageFilter dto = new MessageFilter();
            Message message = m.get();
            dto.setId(message.getId());
            dto.setAuthor(message.getAuthor());
            dto.setContent(message.getContent());
            dto.setCreation_date(message.getCreationDate());
            return dto;
        }
        return null; //does not exists
    }

    @Override
    public MessageFilter postMessage(Message message){
        //Retorna la dto del message creado
        MessageFilter m = new MessageFilter();
        m.setId(message.getId());
        m.setContent(message.getContent());
        m.setAuthor(message.getAuthor());
        m.setCreation_date(message.getCreationDate());
        messageRepository.save(message); //guardo en la DB
        return m;
    }

    @Override
    public void deleteMessageById(Integer id){
        messageRepository.deleteById(id);
    }

}
