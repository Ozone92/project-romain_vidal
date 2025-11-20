package com.example.project_vidal_romain.controller;

import com.example.project_vidal_romain.DTO.Response.ConseillerReponseDTO;
import com.example.project_vidal_romain.converters.Converters;
import com.example.project_vidal_romain.entity.Conseiller;
import com.example.project_vidal_romain.service.IConseillerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ConseillerController{
    private final IConseillerService service;

    @GetMapping("conseillers")
    public List<ConseillerReponseDTO> getConseillers(){
        return service.findAll().stream().map(Converters::toDTO).toList();
    }

    @GetMapping("conseillers/{id}")
    public ResponseEntity<ConseillerReponseDTO> getConseillerById(@PathVariable Long id){
        Optional<Conseiller> conseiller = service.findById(id);

        if (conseiller.isPresent()){
            return ResponseEntity.ok(Converters.toDTO(conseiller.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("conseiller")
    public ConseillerReponseDTO addConseiller() {
        return Converters.toDTO(service.createConseiller());
    }
}
