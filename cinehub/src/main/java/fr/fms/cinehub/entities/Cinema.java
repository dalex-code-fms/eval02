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
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @Size(min = 5, max = 100)
    private String address;

    @ManyToOne
//    @JoinColumn(name = "city_id")
    private City city;

    @ManyToMany
    @JoinTable(
            name = "cinema_movie",
            joinColumns = @JoinColumn(name = "cinema_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;

    public Cinema() {
    }

    public Cinema(String name, String address, City city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public Cinema(String name, Long id, String address, City city, List<Movie> movies) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.city = city;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(min = 3, max = 20) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(min = 3, max = 20) String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public @NotNull @Size(min = 5, max = 100) String getAddress() {
        return address;
    }

    public void setAddress(@NotNull @Size(min = 5, max = 100) String address) {
        this.address = address;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Cinema{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + ", city=" + city + ", movies=" + movies + '}';
    }
}
