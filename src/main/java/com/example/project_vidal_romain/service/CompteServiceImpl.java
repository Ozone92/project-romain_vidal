package com.example.project_vidal_romain.service;

import com.example.project_vidal_romain.DTO.Request.CompteDTO;
import com.example.project_vidal_romain.entity.Compte;
import com.example.project_vidal_romain.repository.CompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements ICompteService {
    private final CompteRepository compteRepository;
    private final IClientService clientService;

    @Override
    public List<Compte> findAll() {
        return compteRepository.findAll();
    }

    @Override
    public Optional<Compte> findById(Long id) {
        return compteRepository.findById(id);
    }

    @Override
    public Optional<Compte> createCompte(CompteDTO compteDTO) {
        var clientOptional = clientService.findById(compteDTO.clientId());

        if (clientOptional.isEmpty()) {
            return Optional.empty();
        }

        var client = clientOptional.get();
        var compte = new Compte();

        compte.setClient(client);
        compte.setMoney(compteDTO.money());
        compte.setCompteType(compteDTO.type());
        compte.setOpenDate(LocalDate.now());

        return Optional.of(compteRepository.save(compte));
    }

    @Override
    public Optional<Compte> addMoney(Long id, Float money) {
        if (money < 0) {
            return Optional.empty();
        }
       var compte = compteRepository.findById(id);
       if (compte.isEmpty()) {
           return Optional.empty();
       }

       compte.get().setMoney(compte.get().getMoney() + money);

       return compte;
    }
}
