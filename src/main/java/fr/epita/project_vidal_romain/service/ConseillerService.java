package fr.epita.project_vidal_romain.service;

import fr.epita.project_vidal_romain.entity.Conseiller;

import java.util.List;
import java.util.Optional;

public interface ConseillerService {
    List<Conseiller> findAll();
    Optional<Conseiller> findById(Long id);
    Conseiller createConseiller();
    Optional<Conseiller> remove(Long id);
}
