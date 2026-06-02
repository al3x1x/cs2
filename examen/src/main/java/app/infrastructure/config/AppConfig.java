package app.infrastructure.config;

import app.domain.ports.AffectedPort;
import app.domain.usecases.ManageAffectedUseCase;
import app.domain.services.AffectedServiceImpl;
import app.infrastructure.persitence.repository.AffectedRepositoryAdapter;
import app.infrastructure.persitence.repository.SpringDataAffectedRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AffectedPort affectedPort(SpringDataAffectedRepository repository) {
        return new AffectedRepositoryAdapter(repository);
    }

    @Bean
    public ManageAffectedUseCase manageAffectedUseCase(AffectedPort affectedPort) {
        return new AffectedServiceImpl(affectedPort);
    }
}
