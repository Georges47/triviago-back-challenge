package austral.triviago.triviagobackchallenge.controller;

import austral.triviago.triviagobackchallenge.business.MessageService;
import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.persistence.exception.NotFoundException;
import austral.triviago.triviagobackchallenge.presentation.controller.MessageController;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(MessageController.class)
public class messageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    
    @Test
    public void testCreateMessage() throws Exception {
        Message message = new Message();
        message.setAuthor("pepe");
        message.setContent("hola como andas?");
        message.setId(1L);
        message.setDate(LocalDate.now());

        when(messageService.saveMessage(Mockito.any(Message.class))).thenReturn(message);

        mockMvc.perform(MockMvcRequestBuilders.post("/messages")
                .content("{\"author\": \"pepe\", \"content\": \"hola como andas?\"}")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value( 1L ));
            
    }

    @Test
    public void testGetMessages() throws Exception {
        // Create a list of mock messages
        List<Message> messages = new ArrayList<>();

        Message message1 = new Message();
        message1.setId(1L);
        message1.setAuthor("pepe");
        message1.setContent("hola como andas?");
        message1.setDate(LocalDate.now());
        messages.add( message1 );

        Message message2 = new Message();
        message2.setId(2L);
        message2.setAuthor("luis");
        message2.setContent("Bien y vos?");
        message2.setDate(LocalDate.now());
        messages.add( message2 );

        // Create a mock Page
        Page<Message> page = new PageImpl<>(messages);

        // Set up mock behavior for messageService.findAll method
        when(messageService.findAll(Mockito.any(MessageFilter.class), (Pageable) Mockito.any(Pageable.class)))
                .thenReturn(page);

        // Perform a GET request to retrieve messages
        mockMvc.perform(MockMvcRequestBuilders.get("/messages"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content[0].id").value(1L))
            .andExpect(jsonPath("$.content[0].author").value("pepe"))
            .andExpect(jsonPath("$.content[0].content").value("hola como andas?"))
            .andExpect(jsonPath("$.content[1].id").value(2L))
            .andExpect(jsonPath("$.content[1].author").value("luis"))
            .andExpect(jsonPath("$.content[1].content").value("Bien y vos?"));
    }

    @Test
    public void testGetMessage() throws Exception {
        Message message = new Message();
        message.setAuthor("pepe");
        message.setContent("hola como andas?");
        message.setId(1L);
        message.setDate(LocalDate.now());

        when(messageService.findById(1L)).thenReturn(message);

        // Perform a GET request to retrieve the saved message
        mockMvc.perform(MockMvcRequestBuilders.get("/messages/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists()) // Expect the id field to be present
                .andExpect(jsonPath("$.author").value("pepe"))
                .andExpect(jsonPath("$.content").value("hola como andas?"));
    }

    @Test
    public void testGetMessageNotFound() throws Exception {
        when(messageService.findById(4L)).thenThrow(new NotFoundException("Message not found"));

        // Perform a GET request to retrieve the message
        mockMvc.perform(MockMvcRequestBuilders.get("/messages/4"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteMessage() throws Exception {
        Message message = new Message();
        message.setAuthor("pepe");
        message.setContent("hola como andas?");
        message.setId(1L);
        message.setDate(LocalDate.now());

        when(messageService.delete(1L)).thenReturn(message);

        // Perform a DELETE request to delete the message
        mockMvc.perform(MockMvcRequestBuilders.delete("/messages/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists()) // Expect the id field to be present
                .andExpect(jsonPath("$.author").value("pepe"))
                .andExpect(jsonPath("$.content").value("hola como andas?"));
    }

    @Test
    public void testDeleteMessageNotFound() throws Exception {
        when(messageService.delete(4L)).thenThrow(new NotFoundException("Message not found"));

        // Perform a DELETE request to delete the message
        mockMvc.perform(MockMvcRequestBuilders.delete("/messages/4"))
                .andExpect(status().isNotFound());
    }


}