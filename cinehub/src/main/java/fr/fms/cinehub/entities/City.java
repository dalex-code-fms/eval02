package fr.fms.cinehub.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
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

}