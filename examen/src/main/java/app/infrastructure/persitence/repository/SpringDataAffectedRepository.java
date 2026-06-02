package app.infrastructure.persitence.repository;

import app.infrastructure.persitence.entities.AffectedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataAffectedRepository extends JpaRepository<AffectedEntity, Long> {
}
