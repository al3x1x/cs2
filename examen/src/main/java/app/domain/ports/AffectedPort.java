package app.domain.ports;

import app.domain.models.Affected;
import java.util.List;
import java.util.Optional;

public interface AffectedPort {
    Affected save(Affected affected);
    Optional<Affected> findById(Long id);
    List<Affected> findAll();
}