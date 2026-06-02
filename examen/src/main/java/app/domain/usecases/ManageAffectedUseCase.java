package app.domain.usecases;

import app.domain.models.Affected;
import java.util.List;
import java.util.Optional;

public interface ManageAffectedUseCase {
    Affected register(Affected affected);
    Optional<Affected> getById(Long id);
    List<Affected> getAll();
    Affected update(Long id, Affected affected);
}