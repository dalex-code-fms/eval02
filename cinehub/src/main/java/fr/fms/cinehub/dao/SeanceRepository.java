package fr.fms.cinehub.dao;

import fr.fms.cinehub.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
