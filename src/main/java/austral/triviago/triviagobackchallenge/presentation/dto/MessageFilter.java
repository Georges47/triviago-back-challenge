package austral.triviago.triviagobackchallenge.presentation.dto;

import java.awt.*;
import java.util.Date;

public class MessageFilter {
    //Dto que uso para el filtrado de información???
    private String author;
    private String content;
    private Date creation_date;  //Se realizan busquedas entre esos dos valores
    private Date since_date;
    private Date to_date;

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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getSince_date() {
        return since_date;
    }

    public void setSince_date(Date since_date) {
        this.since_date = since_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }
}
