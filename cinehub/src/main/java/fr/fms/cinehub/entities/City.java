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
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    @Size(min = 3, max = 20)
    private String department;

    @NotNull
    @Size(min = 4, max = 18)
    private String country;

    @OneToMany(mappedBy = "city")
    private List<Cinema> cinemas;

    public City() {

    }

    public City(String name, String department, String country) {
        this.name = name;
        this.department = department;
        this.country = country;
    }

    public City(Long id, String name, String department, String country, List<Cinema> cinemas) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.country = country;
        this.cinemas = cinemas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(min = 1, max = 50) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(min = 1, max = 50) String name) {
        this.name = name;
    }

    public @NotNull @Size(min = 3, max = 20) String getDepartment() {
        return department;
    }

    public void setDepartment(@NotNull @Size(min = 3, max = 20) String department) {
        this.department = department;
    }

    public @NotNull @Size(min = 4, max = 18) String getCountry() {
        return country;
    }

    public void setCountry(@NotNull @Size(min = 4, max = 18) String country) {
        this.country = country;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name='" + name + '\'' + ", department='" + department + '\'' + ", country='" + country + '\'' +  '}';
    }
}
