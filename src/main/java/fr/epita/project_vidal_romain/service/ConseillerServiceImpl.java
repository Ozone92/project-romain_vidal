package fr.epita.project_vidal_romain.service;

import fr.epita.project_vidal_romain.entity.Conseiller;
import fr.epita.project_vidal_romain.repository.ConseillerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConseillerServiceImpl implements ConseillerService {
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

    @Override
    public Optional<Conseiller> remove(Long id) {
        Optional<Conseiller> conseiller = repository.findById(id);
        conseiller.ifPresent(repository::delete);

        return conseiller;
    }
}
