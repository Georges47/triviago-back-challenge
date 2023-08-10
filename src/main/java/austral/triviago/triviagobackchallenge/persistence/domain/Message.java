package austral.triviago.triviagobackchallenge.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String author;
    private LocalDate creationDate;
    private String content;

    public Message(){}

    public Message(String author, LocalDate creationDateate, String content){
        this.author = author;
        this.creationDate = creationDateate;
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getContent() {
        return content;
    }

}
