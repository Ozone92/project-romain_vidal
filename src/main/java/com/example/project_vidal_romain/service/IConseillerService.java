package com.example.project_vidal_romain.service;

import com.example.project_vidal_romain.entity.Conseiller;

import java.util.List;
import java.util.Optional;

public interface IConseillerService {
    List<Conseiller> findAll();
    Optional<Conseiller> findById(Long id);
    Conseiller createConseiller();
}
