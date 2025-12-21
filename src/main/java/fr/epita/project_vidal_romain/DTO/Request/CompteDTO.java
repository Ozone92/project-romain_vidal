package fr.epita.project_vidal_romain.DTO.Request;

import fr.epita.project_vidal_romain.entity.CompteType;

public record CompteDTO(
        CompteType type,
        Float money,
        Long clientId
) { }
