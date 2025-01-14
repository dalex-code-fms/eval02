package fr.fms.cinehub.dao;

import fr.fms.cinehub.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
