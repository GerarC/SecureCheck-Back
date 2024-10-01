package co.edu.udea.securecheck.configuration;

import co.edu.udea.securecheck.domain.api.*;
import co.edu.udea.securecheck.domain.api.usecase.*;
import co.edu.udea.securecheck.domain.spi.*;
import co.edu.udea.securecheck.domain.utils.annotation.Generated;
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

    @Bean
    public QuestionServicePort questionServicePort() {
        return new QuestionUseCase(
                customQuestionPersistencePort,
                controlPersistencePort,
                companyPersistencePort
        );
    }

    // Security
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
