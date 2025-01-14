package fr.fms.cinehub.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dateTime;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Cinema cinema;

    public Seance() {
    }

    public Seance(LocalDateTime dateTime, Movie movie, Cinema cinema) {
        this.dateTime = dateTime;
        this.movie = movie;
        this.cinema = cinema;
    }

    public Seance(Long id, LocalDateTime dateTime, Movie movie, Cinema cinema) {
        this.id = id;
        this.dateTime = dateTime;
        this.movie = movie;
        this.cinema = cinema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(@NotNull LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return "Seance{" + "id=" + id + ", dateTime=" + dateTime + ", movie=" + movie + ", cinema=" + cinema + '}';
    }
}
