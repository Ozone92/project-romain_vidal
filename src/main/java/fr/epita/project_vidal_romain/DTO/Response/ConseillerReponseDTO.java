package fr.epita.project_vidal_romain.DTO.Response;

import java.util.List;

public record ConseillerReponseDTO(
        Long id,
        List<Long> clientIds
) {
}
