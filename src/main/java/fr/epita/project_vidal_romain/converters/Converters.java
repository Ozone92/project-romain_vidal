package fr.epita.project_vidal_romain.converters;

import fr.epita.project_vidal_romain.DTO.Response.ClientResponseDTO;
import fr.epita.project_vidal_romain.DTO.Response.CompteResponseDTO;
import fr.epita.project_vidal_romain.DTO.Response.ConseillerReponseDTO;
import fr.epita.project_vidal_romain.entity.Client;
import fr.epita.project_vidal_romain.entity.Compte;
import fr.epita.project_vidal_romain.entity.Conseiller;

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

    public static CompteResponseDTO toDTO(Compte compte) {
        return new CompteResponseDTO(
                compte.getId(),
                compte.getMoney(),
                compte.getOpenDate(),
                compte.getCompteType(),
                compte.getClient().getId()
        );
    }
}
