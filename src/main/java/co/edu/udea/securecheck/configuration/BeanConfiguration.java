package co.edu.udea.securecheck.configuration;

import co.edu.udea.securecheck.domain.api.CompanyServicePort;
import co.edu.udea.securecheck.domain.api.ControlServicePort;
import co.edu.udea.securecheck.domain.api.DomainServicePort;
import co.edu.udea.securecheck.domain.api.UserServicePort;
import co.edu.udea.securecheck.domain.api.usecase.CompanyUseCase;
import co.edu.udea.securecheck.domain.api.usecase.ControlUseCase;
import co.edu.udea.securecheck.domain.api.usecase.DomainUseCase;
import co.edu.udea.securecheck.domain.api.usecase.UserUseCase;
import co.edu.udea.securecheck.domain.spi.*;
import co.edu.udea.securecheck.domain.utils.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Generated
@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserPersistencePort userPersistencePort;
    private final DomainPersistencePort domainPersistencePort;
    private final ControlPersistencePort controlPersistencePort;
    private final CompanyPersistencePort companyPersistencePort;
    private final DefaultQuestionPersistencePort defaultQuestionPersistencePort;
    private final CustomQuestionPersistencePort customQuestionPersistencePort;

    @Bean
    public UserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort);
    }

    @Bean
    public DomainServicePort domainServicePort() {
        return new DomainUseCase(domainPersistencePort);
    }

    @Bean
    public ControlServicePort controlServicePort() {
        return new ControlUseCase(controlPersistencePort);
    }

    @Bean
    public CompanyServicePort companyServicePort() {
        return new CompanyUseCase(
                companyPersistencePort,
                userPersistencePort,
                defaultQuestionPersistencePort,
                customQuestionPersistencePort
        );
    }

    // Security
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
