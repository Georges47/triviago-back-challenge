package austral.triviago.triviagobackchallenge.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity

public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private String author;

    private LocalDate creation_date;

    private String content;

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date() {
        this.creation_date = LocalDate.now();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
