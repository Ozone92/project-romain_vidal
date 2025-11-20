package com.example.project_vidal_romain.controller;

import com.example.project_vidal_romain.DTO.Request.CompteDTO;
import com.example.project_vidal_romain.DTO.Request.MoneyDTO;
import com.example.project_vidal_romain.entity.Compte;
import com.example.project_vidal_romain.service.ICompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompteController {
    private final ICompteService compteService;

    @GetMapping("compte")
    public List<Compte> getComptes() {
        return compteService.findAll();
    }

    @GetMapping("compte/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable Long id) {
        var compte = compteService.findById(id);

        if (compte.isPresent()) {
            return ResponseEntity.ok(compte.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("compte")
    public ResponseEntity<Compte> addCompte(@RequestBody CompteDTO compteDTO) {
        var compte = compteService.createCompte(compteDTO);

        if (compte.isPresent()) {
            return ResponseEntity.ok(compte.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("compte/{id}/add")
    public ResponseEntity<Compte> addMoney(@PathVariable Long id, @RequestBody MoneyDTO money) {
        var compte = compteService.addMoney(id, money.money());

        if (compte.isPresent()) {
            return ResponseEntity.ok(compte.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("compte/{id}/withdraw")
    public ResponseEntity<Compte> removeMoney(@PathVariable Long id, @RequestBody MoneyDTO money) {
        var compte = compteService.withdrawMoney(id, money.money());

        if (compte.isPresent()) {
            return ResponseEntity.ok(compte.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
