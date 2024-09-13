package co.edu.udea.securecheck.domain.spi;

import co.edu.udea.securecheck.domain.model.Company;
import co.edu.udea.securecheck.domain.model.User;

import java.util.List;

public interface UserPersistencePort {
    User save(User user);
    boolean existsByEmail(String email);
    boolean existsByIdentityDocument(String identityDocument);
    boolean existsById(String id);
    List<Company> getUserCompanies(String id);
}
