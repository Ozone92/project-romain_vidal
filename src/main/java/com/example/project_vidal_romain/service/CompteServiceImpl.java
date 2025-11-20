package com.example.project_vidal_romain.service;

import com.example.project_vidal_romain.DTO.CompteDTO;
import com.example.project_vidal_romain.entity.Compte;
import com.example.project_vidal_romain.repository.CompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements ICompteService {
    private final CompteRepository compteRepository;

    @Override
    public List<Compte> findAll() {
        return compteRepository.findAll();
    }

    @Override
    public Optional<Compte> findById(Long id) {
        return compteRepository.findById(id);
    }

    @Override
    public Compte createCompte(CompteDTO compteDTO) {
        return null;
    }

    @Override
    public Optional<Compte> addMoney(Long id, Float money) {
       var compte = compteRepository.findById(id);
       if (compte.isEmpty()) {
           return Optional.empty();
       }

       compte.get().setMoney(compte.get().getMoney() + money);

       return compte;
    }
}
