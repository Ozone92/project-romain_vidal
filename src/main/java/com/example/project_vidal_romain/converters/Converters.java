package com.example.project_vidal_romain.converters;

import com.example.project_vidal_romain.DTO.Response.ClientResponseDTO;
import com.example.project_vidal_romain.DTO.Response.ConseillerReponseDTO;
import com.example.project_vidal_romain.entity.Client;
import com.example.project_vidal_romain.entity.Compte;
import com.example.project_vidal_romain.entity.Conseiller;

public class Converters {
    public static ClientResponseDTO toDTO(Client client) {
        return new ClientResponseDTO(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getAddress(),
                client.getPostal(),
                client.getCity(),
                client.getPhone(),
                client.getConseiller().getId(),
                client.getComptes().stream().map(Compte::getId).toList()
        );
    }

    public static ConseillerReponseDTO toDTO(Conseiller conseiller) {
        return new ConseillerReponseDTO(
                conseiller.getId(),
                conseiller.getClients().stream().map(Client::getId).toList()
        );
    }
}
