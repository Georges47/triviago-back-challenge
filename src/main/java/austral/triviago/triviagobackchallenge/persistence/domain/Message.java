package austral.triviago.triviagobackchallenge.persistence.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySql soporta columnas con autoincremento
    private Integer Id;
    @Column
    private String author; //Es el autor
    @Column
    private String content; //Es el body
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy") //pattern indica a Jackson cómo se debe leer la fecha recibida
    private Date creationDate; // Vas a tener que usar Date (:

    public Message() {}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer primaryKey) {
        this.Id = primaryKey;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreation_date(Date date) throws ParseException {
        this.creationDate = date;
    }
}
