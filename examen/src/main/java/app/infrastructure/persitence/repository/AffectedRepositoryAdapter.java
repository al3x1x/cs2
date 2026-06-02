package app.infrastructure.persitence.repository;

import app.domain.models.Affected;
import app.domain.ports.AffectedPort;
import app.infrastructure.persitence.entities.AffectedEntity;
import app.infrastructure.persitence.mapper.AffectedMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AffectedRepositoryAdapter implements AffectedPort {

    private final SpringDataAffectedRepository repository;

    public AffectedRepositoryAdapter(SpringDataAffectedRepository repository) {
        this.repository = repository;
    }

    @Override
    public Affected save(Affected affected) {
        AffectedEntity entity = AffectedMapper.toEntity(affected);
        AffectedEntity saved = repository.save(entity);
        return AffectedMapper.toDomain(saved);
    }

    @Override
    public Optional<Affected> findById(Long id) {
        return repository.findById(id).map(AffectedMapper::toDomain);
    }

    @Override
    public List<Affected> findAll() {
        return repository.findAll().stream()
                .map(AffectedMapper::toDomain)
                .collect(Collectors.toList());
    }
}
