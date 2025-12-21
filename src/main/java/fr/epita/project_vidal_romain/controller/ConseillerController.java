package fr.epita.project_vidal_romain.controller;

import fr.epita.project_vidal_romain.DTO.Response.CompteResponseDTO;
import fr.epita.project_vidal_romain.DTO.Response.ConseillerReponseDTO;
import fr.epita.project_vidal_romain.converters.Converters;
import fr.epita.project_vidal_romain.entity.Compte;
import fr.epita.project_vidal_romain.entity.Conseiller;
import fr.epita.project_vidal_romain.service.ConseillerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ConseillerController{
    private final ConseillerService service;

    @GetMapping("conseiller")
    public List<ConseillerReponseDTO> getConseillers(){
        return service.findAll().stream().map(Converters::toDTO).toList();
    }

    @GetMapping("conseiller/{id}")
    public ResponseEntity<ConseillerReponseDTO> getConseillerById(@PathVariable Long id){
        Optional<Conseiller> conseiller = service.findById(id);

        return conseiller.map(value -> ResponseEntity.ok(Converters.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }

    @PostMapping("conseiller")
    public ConseillerReponseDTO addConseiller() {
        return Converters.toDTO(service.createConseiller());
    }

    @DeleteMapping("conseiller/{id}")
    public ResponseEntity<ConseillerReponseDTO> removeConseillerById(@PathVariable Long id) {
        Optional<Conseiller> conseiller = service.remove(id);

        return conseiller.map(value -> ResponseEntity.ok(Converters.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound()
                        .build()
                );
    }
}
