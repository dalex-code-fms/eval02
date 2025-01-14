package fr.fms.cinehub.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String title;

    @ManyToMany(mappedBy = "movies")
    private List<Cinema> cinemas;

    @OneToMany(mappedBy = "movie")
    private List<Seance> seances;

    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
    }

    public Movie(Long id, String title, List<Cinema> cinemas, List<Seance> seances) {
        this.id = id;
        this.title = title;
        this.cinemas = cinemas;
        this.seances = seances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(min = 1, max = 50) String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @Size(min = 1, max = 50) String title) {
        this.title = title;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title='" + title + '\'' + ", cinemas=" + cinemas + ", seances=" + seances + '}';
    }
}
