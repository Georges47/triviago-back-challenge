package austral.triviago.triviagobackchallenge.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;

public class messageTest {

    @Test
    public void testGetterAndSetterMethods() {
        Message message = new Message();
        message.setId(1L);
        message.setAuthor("pepe");
        message.setContent("Hello, world!");
        LocalDate currentDate = LocalDate.now();
        message.setDate(currentDate);

        assertEquals(1L, message.getId());
        assertEquals("pepe", message.getAuthor());
        assertEquals("Hello, world!", message.getContent());
        assertEquals(currentDate, message.getDate());
    }

    @Test
    public void testEqualsAndHashCode() {
        Message message1 = new Message();
        message1.setId(1L);
        message1.setAuthor("pepe");
        message1.setContent("Hello, world!");
        LocalDate currentDate = LocalDate.now();
        message1.setDate(currentDate);

        Message message2 = new Message();
        message2.setId(1L);
        message2.setAuthor("pepe");
        message2.setContent("Hello, world!");
        message2.setDate(currentDate);

        assertEquals(message1, message2);
        assertEquals(message1.hashCode(), message2.hashCode());

        message2.setId(2L);

        assertNotEquals(message1, message2);
    }

    @Test
    public void testValidationAnnotations() {
        Message message = new Message();
        message.setAuthor(null);
        message.setContent(null);
        message.setDate(null);

        assertTrue(message.getAuthor() == null);
        assertTrue(message.getContent() == null);
        assertTrue(message.getDate() == null);
    }
}
