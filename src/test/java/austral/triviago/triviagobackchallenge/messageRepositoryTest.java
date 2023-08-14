package austral.triviago.triviagobackchallenge;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.persistence.repository.MessageRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Disable automatic replacement
public class messageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testSaveMessage() {
        // Create a new Message entity
        Message message = new Message();
        message.setAuthor("pepe");
        message.setContent("Hello, world!");

        // Save the message using the repository
        Message savedMessage = messageRepository.save(message);

        // Verify that the message was saved and has an ID assigned
        assertThat(savedMessage.getId()).isNotNull();
        assertThat(savedMessage.getAuthor()).isEqualTo("pepe");
        assertThat(savedMessage.getContent()).isEqualTo("Hello, world!");
    }

    @Test
    public void testFindById() {
        // Create a new Message entity and save it
        Message message = new Message();
        message.setAuthor("pepe");
        message.setContent("Hello, world!");
        Message savedMessage = messageRepository.save(message);

        // Retrieve the message using findById
        Message retrievedMessage = messageRepository.findById(savedMessage.getId()).orElse(null);

        // Verify that the retrieved message matches the saved message
        assertThat(retrievedMessage).isNotNull();
        assertThat(retrievedMessage.getId()).isEqualTo(savedMessage.getId());
        assertThat(retrievedMessage.getAuthor()).isEqualTo("pepe");
        assertThat(retrievedMessage.getContent()).isEqualTo("Hello, world!");
    }

    @Test
    public void testDeleteMessage() {
        // Create a message and save it to the repository
        Message message = new Message();
        message.setAuthor("pepe");
        message.setContent("hola como andas?");
        messageRepository.save(message);

        // Verify that the message is saved
        assertTrue(messageRepository.existsById(message.getId()));

        // Delete the message
        messageRepository.deleteById(message.getId());

        // Verify that the message is deleted
        assertFalse(messageRepository.existsById(message.getId()));
    }

}
