package austral.triviago.triviagobackchallenge;

import austral.triviago.triviagobackchallenge.business.impl.MessageServiceImpl;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.persistence.exception.NotFoundException;
import austral.triviago.triviagobackchallenge.persistence.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class messageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageServiceImpl messageService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByIdSuccess() {
        Message mockMessage = new Message();
        mockMessage.setId(1L);
        mockMessage.setAuthor("pepe");
        mockMessage.setContent("hola como andas?");
        mockMessage.setDate(LocalDate.now());

        when(messageRepository.findById(1L)).thenReturn(Optional.of(mockMessage));

        Message result = messageService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("pepe", result.getAuthor());
        assertEquals("hola como andas?", result.getContent());
        assertNotNull(result.getDate());

        verify(messageRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindByIdNotFound() {
        when(messageRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> messageService.findById(1L));

        verify(messageRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveMessage() {
        Message requestMessage = new Message();
        requestMessage.setAuthor("pepe");
        requestMessage.setContent("hola como andas?");

        Message mockSavedMessage = new Message();
        mockSavedMessage.setId(1L);
        mockSavedMessage.setAuthor("pepe");
        mockSavedMessage.setContent("hola como andas?");
        mockSavedMessage.setDate(LocalDate.now());

        when(messageRepository.save(any(Message.class))).thenReturn(mockSavedMessage);

        Message result = messageService.saveMessage(requestMessage);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("pepe", result.getAuthor());
        assertEquals("hola como andas?", result.getContent());
        assertNotNull(result.getDate());

        verify(messageRepository, times(1)).save(any(Message.class));
    }

    @Test
    public void testDeleteSuccess() {
        Message mockMessage = new Message();
        mockMessage.setId(1L);
        mockMessage.setAuthor("pepe");
        mockMessage.setContent("hola como andas?");
        mockMessage.setDate(LocalDate.now());

        when(messageRepository.findById(1L)).thenReturn(Optional.of(mockMessage));

        Message result = messageService.delete(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("pepe", result.getAuthor());
        assertEquals("hola como andas?", result.getContent());
        assertNotNull(result.getDate());

        verify(messageRepository, times(1)).findById(1L);
        verify(messageRepository, times(1)).delete(mockMessage);
    }

    @Test
    public void testDeleteNotFound() {
        when(messageRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> messageService.delete(1L));

        verify(messageRepository, times(1)).findById(1L);
        verify(messageRepository, never()).delete(any(Message.class));
    }

}