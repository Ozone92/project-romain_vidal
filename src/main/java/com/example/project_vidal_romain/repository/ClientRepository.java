package com.example.project_vidal_romain.repository;

import com.example.project_vidal_romain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
