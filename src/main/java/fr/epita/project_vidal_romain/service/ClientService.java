package fr.epita.project_vidal_romain.service;

import fr.epita.project_vidal_romain.DTO.Request.ClientDTO;
import fr.epita.project_vidal_romain.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();
    Optional<Client> findById(Long id);
    Optional<Client> createClient(ClientDTO clientDTO);
    Optional<Client> deleteClientById(Long id);
}
