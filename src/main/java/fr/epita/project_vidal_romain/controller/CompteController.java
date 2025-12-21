package fr.epita.project_vidal_romain.controller;

import fr.epita.project_vidal_romain.DTO.Request.CompteDTO;
import fr.epita.project_vidal_romain.DTO.Request.MoneyDTO;
import fr.epita.project_vidal_romain.DTO.Response.CompteResponseDTO;
import fr.epita.project_vidal_romain.converters.Converters;
import fr.epita.project_vidal_romain.entity.Compte;
import fr.epita.project_vidal_romain.service.CompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CompteController {
    private final CompteService compteService;

    @GetMapping("compte")
    public List<Compte> getComptes() {
        return compteService.findAll();
    }

    @GetMapping("compte/{id}")
    public ResponseEntity<CompteResponseDTO> getCompteById(@PathVariable Long id) {
        var compte = compteService.findById(id);

        return compte.map(value -> ResponseEntity.ok(Converters.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound()
                        .build()
                );
    }

    @PostMapping("compte")
    public ResponseEntity<CompteResponseDTO> addCompte(@RequestBody CompteDTO compteDTO) {
        var compte = compteService.createCompte(compteDTO);

        return compte.map(value -> ResponseEntity.ok(Converters.toDTO(value)))
                .orElseGet(() -> ResponseEntity.badRequest()
                        .build()
                );
    }

    @PutMapping("compte/{id}/add")
    public ResponseEntity<CompteResponseDTO> addMoney(@PathVariable Long id, @RequestBody MoneyDTO money) {
        var compte = compteService.addMoney(id, money.money());

        return compte.map(value -> ResponseEntity.ok(Converters.toDTO(value)))
                .orElseGet(() -> ResponseEntity.badRequest()
                        .build()
                );
    }

    @PutMapping("compte/{id}/withdraw")
    public ResponseEntity<CompteResponseDTO> removeMoney(@PathVariable Long id, @RequestBody MoneyDTO money) {
        var compte = compteService.withdrawMoney(id, money.money());

        return compte.map(value -> ResponseEntity.ok(Converters.toDTO(value)))
                .orElseGet(() -> ResponseEntity.badRequest()
                        .build()
                );
    }

    @DeleteMapping("compte/{id}")
    public ResponseEntity<CompteResponseDTO> removeCompteById(@PathVariable Long id) {
        Optional<Compte> compte = compteService.remove(id);

        return compte.map(value -> ResponseEntity.ok(Converters.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound()
                        .build()
                );
    }
}
