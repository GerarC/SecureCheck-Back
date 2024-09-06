package co.edu.udea.securecheck.configuration;


import co.edu.udea.securecheck.adapter.driven.jpa.entity.RoleEntity;
import co.edu.udea.securecheck.adapter.driven.jpa.entity.UserEntity;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.RoleRepository;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.UserRepository;
import co.edu.udea.securecheck.domain.utils.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Initialization {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            List<RoleEntity> roles = List.of(
                    new RoleEntity(null, RoleName.ADMIN),
                    new RoleEntity(null, RoleName.AUDITOR),
                    new RoleEntity(null, RoleName.AUDITED)
            );
            roleRepository.saveAll(roles);

            List<UserEntity> users = List.of(
                    new UserEntity(
                            null,
                            "Admin",
                            "Admin",
                            "0000000001",
                            LocalDateTime.of(2000, 1, 1, 1, 1),
                            "+57 3013424656",
                            "admin@admin.com",
                            passwordEncoder.encode("#P4ssw0rd*"),
                            roles.get(0))
            );
            userRepository.saveAll(users);
        };
    }
}
