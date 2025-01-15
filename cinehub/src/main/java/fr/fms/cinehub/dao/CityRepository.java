package fr.fms.cinehub.dao;

import fr.fms.cinehub.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByName(String name);

}
