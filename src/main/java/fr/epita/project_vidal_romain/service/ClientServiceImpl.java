package fr.epita.project_vidal_romain.service;

import fr.epita.project_vidal_romain.DTO.Request.ClientDTO;
import fr.epita.project_vidal_romain.entity.Client;
import fr.epita.project_vidal_romain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ConseillerService conseillerService;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> createClient(ClientDTO clientDTO) {
        var conseiller = conseillerService.findById(clientDTO.getConseillerId());
        if (conseiller.isEmpty()) {
            return Optional.empty();
        }

        Client client = new Client();

        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setAddress(clientDTO.getAddress());
        client.setPostal(clientDTO.getPostal());
        client.setCity(clientDTO.getCity());
        client.setPhone(clientDTO.getPhone());
        client.setConseiller(conseiller.get());

        client = clientRepository.save(client);

        return Optional.of(client);
    }

    @Override
    public Optional<Client> deleteClientById(Long id) {
        var client = clientRepository.findById(id);
        client.ifPresent(clientRepository::delete);

        return client;
    }
}
