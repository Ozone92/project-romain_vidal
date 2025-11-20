package com.example.project_vidal_romain.controller;

import com.example.project_vidal_romain.entity.Conseiller;
import com.example.project_vidal_romain.service.IConseillerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ConseillerController{
    private final IConseillerService service;

    @GetMapping("conseillers")
    public List<Conseiller> getConseillers(){
        return service.findAll();
    }

    @GetMapping("conseillers/{id}")
    public ResponseEntity<Conseiller> getConseillerById(@PathVariable Long id){
        Optional<Conseiller> conseiller = service.findById(id);
        if (conseiller.isPresent()){
            return ResponseEntity.ok(conseiller.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("conseillers")
    public Conseiller addConseiller() {
        return service.createConseiller();
    }
}
