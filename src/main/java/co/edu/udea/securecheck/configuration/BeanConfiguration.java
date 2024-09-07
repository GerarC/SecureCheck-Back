package co.edu.udea.securecheck.configuration;

import co.edu.udea.securecheck.adapter.driven.jpa.adapters.DomainJpaAdapter;
import co.edu.udea.securecheck.adapter.driven.jpa.adapters.UserJpaAdapter;
import co.edu.udea.securecheck.adapter.driven.jpa.mapper.DomainEntityMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.mapper.UserEntityMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.DomainRepository;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.UserRepository;
import co.edu.udea.securecheck.domain.api.DomainServicePort;
import co.edu.udea.securecheck.domain.api.UserServicePort;
import co.edu.udea.securecheck.domain.api.usecase.DomainUseCase;
import co.edu.udea.securecheck.domain.api.usecase.UserUseCase;
import co.edu.udea.securecheck.domain.spi.DomainPersistencePort;
import co.edu.udea.securecheck.domain.spi.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final DomainRepository domainRepository;
    private final DomainEntityMapper domainEntityMapper;

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public UserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public DomainPersistencePort domainPersistencePort() {
        return new DomainJpaAdapter(domainRepository, domainEntityMapper);
    }

    @Bean
    public DomainServicePort domainServicePort() {
        return new DomainUseCase(domainPersistencePort());
    }

    // Security

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
