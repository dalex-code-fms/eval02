package fr.fms.cinehub.dao;

import fr.fms.cinehub.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    List<Cinema> findAllByCityName(String cityName);
    List<Cinema> findAllByNameContaining(String cinemaName);
}
