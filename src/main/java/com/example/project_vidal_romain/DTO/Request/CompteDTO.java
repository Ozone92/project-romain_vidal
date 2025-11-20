package com.example.project_vidal_romain.DTO.Request;

import com.example.project_vidal_romain.entity.CompteType;

public record CompteDTO(
        CompteType type,
        Float money,
        Long clientId
) { }
