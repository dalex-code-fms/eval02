package fr.fms.cinehub.dao;

import fr.fms.cinehub.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
