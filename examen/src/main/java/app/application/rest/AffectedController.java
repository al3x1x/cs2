package app.application.rest;

import app.domain.models.Affected;
import app.domain.usecases.ManageAffectedUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/afectados")
public class AffectedController {

    private final ManageAffectedUseCase useCase;

    public AffectedController(ManageAffectedUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<Affected> registerAffected(@RequestBody Affected affected) {
        return ResponseEntity.ok(useCase.register(affected));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Affected> getAffectedById(@PathVariable Long id) {
        return useCase.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Affected>> getAllAffected() {
        return ResponseEntity.ok(useCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Affected> updateAffected(@PathVariable Long id, @RequestBody Affected affected) {
        try {
            return ResponseEntity.ok(useCase.update(id, affected));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
