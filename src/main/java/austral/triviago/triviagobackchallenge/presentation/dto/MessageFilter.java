package austral.triviago.triviagobackchallenge.presentation.dto;

import java.time.LocalDate;

public class MessageFilter {
    private String author;
    private LocalDate dateTo;
    private LocalDate dateFrom;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate date) {
        this.dateTo = date;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate date) {
        this.dateFrom = date;
    }
}
