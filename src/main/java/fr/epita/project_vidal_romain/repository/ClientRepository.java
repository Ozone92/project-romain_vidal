package fr.epita.project_vidal_romain.repository;

import fr.epita.project_vidal_romain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
