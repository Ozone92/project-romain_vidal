package com.example.project_vidal_romain.DTO.Request;

public record TransferDTO(
        Long otherId,
        Long compteId,
        Long otherCompteId,
        Float money
) { }
