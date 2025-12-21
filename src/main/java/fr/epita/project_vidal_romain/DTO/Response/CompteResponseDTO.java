package fr.epita.project_vidal_romain.DTO.Response;

import fr.epita.project_vidal_romain.entity.CompteType;

import java.time.LocalDate;

public record CompteResponseDTO(
        Long id,
        Float money,
        LocalDate openDate,
        CompteType type,
        Long clientId
) {
}
