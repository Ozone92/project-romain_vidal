package com.example.project_vidal_romain.controller;

import com.example.project_vidal_romain.entity.Compte;
import com.example.project_vidal_romain.service.ICompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
