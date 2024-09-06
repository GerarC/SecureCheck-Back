package co.edu.udea.securecheck.adapter.driven.jpa.repository;

import co.edu.udea.securecheck.adapter.driven.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    public UserEntity findByEmail(String email);
}
