package com.example.project_vidal_romain.repository;

import com.example.project_vidal_romain.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
