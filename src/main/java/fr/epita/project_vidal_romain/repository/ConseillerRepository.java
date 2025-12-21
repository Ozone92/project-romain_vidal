package fr.epita.project_vidal_romain.repository;

import fr.epita.project_vidal_romain.entity.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConseillerRepository extends JpaRepository<Conseiller, Long> {
}
