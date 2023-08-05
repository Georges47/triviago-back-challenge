package austral.triviago.triviagobackchallenge.persistence.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySql soporta columnas con autoincremento
    private Integer primaryKey;
    @Column
    private String Author; //Es el autor
    @Column
    private String content; //Es el body
    @Column
    private Date creation_date; // Vas a tener que usar Date

    public Message() {}

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
