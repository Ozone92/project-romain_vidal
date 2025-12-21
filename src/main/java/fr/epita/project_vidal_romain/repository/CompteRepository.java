package fr.epita.project_vidal_romain.repository;

import fr.epita.project_vidal_romain.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
