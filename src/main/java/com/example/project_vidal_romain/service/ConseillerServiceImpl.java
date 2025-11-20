package com.example.project_vidal_romain.service;

import com.example.project_vidal_romain.entity.Conseiller;
import com.example.project_vidal_romain.repository.ConseillerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConseillerServiceImpl implements IConseillerService {
    private final ConseillerRepository repository;

    @Override
    public List<Conseiller> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Conseiller> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Conseiller createConseiller() {
        Conseiller conseiller = new Conseiller();
        return repository.save(conseiller);
    }
}
