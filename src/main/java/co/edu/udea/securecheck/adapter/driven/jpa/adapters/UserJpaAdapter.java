package co.edu.udea.securecheck.adapter.driven.jpa.adapters;

import co.edu.udea.securecheck.adapter.driven.jpa.entity.CompanyEntity;
import co.edu.udea.securecheck.adapter.driven.jpa.entity.UserEntity;
import co.edu.udea.securecheck.adapter.driven.jpa.mapper.CompanyEntityMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.mapper.SortJPAMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.mapper.UserEntityMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.CompanyRepository;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.UserRepository;
import co.edu.udea.securecheck.adapter.driven.jpa.specification.CompanySpecification;
import co.edu.udea.securecheck.domain.exceptions.TypeAttributeDoesntExistsException;
import co.edu.udea.securecheck.domain.model.Company;
import co.edu.udea.securecheck.domain.model.Control;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.spi.UserPersistencePort;
import co.edu.udea.securecheck.domain.utils.SortQuery;
import co.edu.udea.securecheck.domain.utils.filters.CompanyFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements UserPersistencePort {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final UserEntityMapper userEntityMapper;
    private final CompanyEntityMapper companyEntityMapper;
    private final SortJPAMapper sortJPAMapper;

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

    @Override
    public List<Company> getUserCompanies(String id, SortQuery sortQuery, CompanyFilter filter) {
        Sort sort = sortQuery != null ? sortJPAMapper.toJPA(sortQuery).createSort() : Sort.unsorted();
        Specification<CompanyEntity> specs = CompanySpecification.filterBy(id, filter);
        try {
            List<CompanyEntity> companies = companyRepository.findAll(specs, sort);
            return companyEntityMapper.toDomains(companies);
        } catch (PropertyReferenceException e) {
            String column = sortQuery == null ? "" : sortQuery.getSortBy();
            throw new TypeAttributeDoesntExistsException(column, Control.class.getSimpleName());
        }
    }
}
