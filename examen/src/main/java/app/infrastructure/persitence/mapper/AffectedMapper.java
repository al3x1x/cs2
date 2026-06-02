package app.infrastructure.persitence.mapper;

import app.domain.models.Affected;
import app.infrastructure.persitence.entities.AffectedEntity;

public class AffectedMapper {

    public static Affected toDomain(AffectedEntity entity) {
        if (entity == null) return null;
        return new Affected(
            entity.getId(),
            entity.getName(),
            entity.getRiskLevel(),
            entity.getAggressivenessLevel(),
            entity.getLocation()
        );
    }

    public static AffectedEntity toEntity(Affected domain) {
        if (domain == null) return null;
        AffectedEntity entity = new AffectedEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setRiskLevel(domain.getRiskLevel());
        entity.setAggressivenessLevel(domain.getAggressivenessLevel());
        entity.setLocation(domain.getLocation());
        return entity;
    }
}
