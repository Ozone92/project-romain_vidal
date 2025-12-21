package fr.epita.project_vidal_romain.controller;

import fr.epita.project_vidal_romain.DTO.Request.ClientDTO;
import fr.epita.project_vidal_romain.DTO.Response.ClientResponseDTO;
import fr.epita.project_vidal_romain.converters.Converters;
import fr.epita.project_vidal_romain.entity.Client;
import fr.epita.project_vidal_romain.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping("client")
    public List<ClientResponseDTO> getClients() {
        return service.findAll().stream().map(Converters::toDTO).toList();
    }

    @GetMapping("client/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id) {
        Optional<Client> client = service.findById(id);

        return client.map(value -> ResponseEntity.ok(Converters.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }

    @PostMapping("client")
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientDTO clientDTO) {
        var client = service.createClient(clientDTO);
        return client.map(value -> ResponseEntity.ok(Converters.toDTO(value)))
                .orElseGet(() -> ResponseEntity.badRequest()
                        .build());
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity<ClientResponseDTO> deleteClientById(@PathVariable Long id) {
        Optional<Client> client = service.deleteClientById(id);

        return client.map(value -> ResponseEntity.ok(Converters.toDTO(value)))
                .orElseGet(() -> ResponseEntity.badRequest()
                        .build());
    }
}
