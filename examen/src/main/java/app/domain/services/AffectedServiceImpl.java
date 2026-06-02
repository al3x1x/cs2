package app.domain.services;

import app.domain.models.Affected;
import app.domain.ports.AffectedPort;
import app.domain.usecases.ManageAffectedUseCase;
import java.util.List;
import java.util.Optional;

public class AffectedServiceImpl implements ManageAffectedUseCase {

    private final AffectedPort affectedPort;

    public AffectedServiceImpl(AffectedPort affectedPort) {
        this.affectedPort = affectedPort;
    }

    @Override
    public Affected register(Affected affected) {
        if (affected.getAggressivenessLevel() != null && affected.getAggressivenessLevel() > 7) {
            affected.setRiskLevel("CRITICAL - HIGH");
        }
        return affectedPort.save(affected);
    }

    @Override
    public Optional<Affected> getById(Long id) {
        return affectedPort.findById(id);
    }

    @Override
    public List<Affected> getAll() {
        return affectedPort.findAll();
    }

    @Override
    public Affected update(Long id, Affected newAffected) {
        return affectedPort.findById(id)
                .map(existing -> {
                    existing.setName(newAffected.getName());
                    existing.setLocation(newAffected.getLocation());
                    existing.setAggressivenessLevel(newAffected.getAggressivenessLevel());

                    if (newAffected.getAggressivenessLevel() != null && newAffected.getAggressivenessLevel() > 7) {
                        existing.setRiskLevel("CRITICAL - HIGH");
                    } else {
                        existing.setRiskLevel(newAffected.getRiskLevel());
                    }
                    return affectedPort.save(existing);
                }).orElseThrow(() -> new RuntimeException("Affected individual not found with ID: " + id));
    }
}