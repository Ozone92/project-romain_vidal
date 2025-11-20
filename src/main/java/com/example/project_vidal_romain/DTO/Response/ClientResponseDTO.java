package com.example.project_vidal_romain.DTO.Response;

import java.util.List;

public record ClientResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String address,
        Integer postal,
        String city,
        Integer phone,
        Long conseillerId,
        List<Long> compteIds
) {
}
