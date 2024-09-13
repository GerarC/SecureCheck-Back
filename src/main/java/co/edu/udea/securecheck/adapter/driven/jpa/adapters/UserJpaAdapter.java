package co.edu.udea.securecheck.adapter.driven.jpa.adapters;

import co.edu.udea.securecheck.adapter.driven.jpa.entity.UserEntity;
import co.edu.udea.securecheck.adapter.driven.jpa.mapper.UserEntityMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.UserRepository;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.spi.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements UserPersistencePort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User save(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        return userEntityMapper.toDomain(userRepository.save(entity));
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByIdentityDocument(String identityDocument) {
        return userRepository.existsByIdentityDocument(identityDocument);
    }

    @Override
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }
}
