package co.edu.udea.securecheck.configuration;

import co.edu.udea.securecheck.adapter.driven.jpa.adapters.UserJpaAdapter;
import co.edu.udea.securecheck.adapter.driven.jpa.mapper.UserEntityMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.UserRepository;
import co.edu.udea.securecheck.domain.api.UserServicePort;
import co.edu.udea.securecheck.domain.api.usecase.UserUseCase;
import co.edu.udea.securecheck.domain.spi.UserPersitencePort;
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

    @Bean
    public UserPersitencePort userPersitencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public UserServicePort userServicePort(){
        return new UserUseCase(userPersitencePort());
    }


    // Security

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
