package com.example.project_vidal_romain.controller;

import com.example.project_vidal_romain.DTO.ClientDTO;
import com.example.project_vidal_romain.entity.Client;
import com.example.project_vidal_romain.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final IClientService service;

    @GetMapping("client")
    public List<Client> getClients() {
        return service.findAll();
    }

    @GetMapping("client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        Optional<Client> client = service.findById(id);

        if (client.isPresent()){
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("client")
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO) {
        var client = service.createClient(clientDTO);

        if (client.isPresent()){
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
