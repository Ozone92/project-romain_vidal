package com.example.project_vidal_romain.controller;

import com.example.project_vidal_romain.DTO.Request.ClientDTO;
import com.example.project_vidal_romain.DTO.Response.ClientResponseDTO;
import com.example.project_vidal_romain.converters.Converters;
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
    public List<ClientResponseDTO> getClients() {
        return service.findAll().stream().map(Converters::toDTO).toList();
    }

    @GetMapping("client/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id) {
        Optional<Client> client = service.findById(id);

        if (client.isPresent()){
            return ResponseEntity.ok(Converters.toDTO(client.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("client")
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientDTO clientDTO) {
        var client = service.createClient(clientDTO);

        if (client.isPresent()){
            return ResponseEntity.ok(Converters.toDTO(client.get()));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
