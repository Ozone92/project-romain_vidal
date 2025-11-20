package com.example.project_vidal_romain.service;

import com.example.project_vidal_romain.DTO.Request.CompteDTO;
import com.example.project_vidal_romain.entity.Compte;

import java.util.List;
import java.util.Optional;

public interface ICompteService {
    List<Compte> findAll();
    Optional<Compte> findById(Long id);

    Optional<Compte> createCompte(CompteDTO compteDTO);
    Optional<Compte> addMoney(Long id, Float money);
}
