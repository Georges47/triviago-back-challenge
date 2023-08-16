package austral.triviago.triviagobackchallenge.presentation.dto;

import java.time.LocalDate;

public class MessageFilter {
    private String author;
    private LocalDate dateFrom;
    private LocalDate dateTo;


    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
