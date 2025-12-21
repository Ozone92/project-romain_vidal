package fr.epita.project_vidal_romain.service;

import fr.epita.project_vidal_romain.DTO.Request.CompteDTO;
import fr.epita.project_vidal_romain.entity.Compte;

import java.util.List;
import java.util.Optional;

public interface CompteService {
    List<Compte> findAll();
    Optional<Compte> findById(Long id);

    Optional<Compte> createCompte(CompteDTO compteDTO);
    Optional<Compte> addMoney(Long id, Float money);
    Optional<Compte> withdrawMoney(Long id, Float money);
    Optional<Compte> remove(Long id);
}
