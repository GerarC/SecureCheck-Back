package co.edu.udea.securecheck.adapter.driven.jpa.adapters;

import co.edu.udea.securecheck.adapter.driven.jpa.entity.CompanyEntity;
import co.edu.udea.securecheck.adapter.driven.jpa.mapper.CompanyEntityMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.CompanyRepository;
import co.edu.udea.securecheck.domain.model.Company;
import co.edu.udea.securecheck.domain.spi.CompanyPersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyJpaAdapter implements CompanyPersistencePort {
    private final CompanyRepository companyRepository;
    private final CompanyEntityMapper companyEntityMapper;

    @Override
    @Transactional
    public Company createCompany(Company company) {
        CompanyEntity entity = companyEntityMapper.toEntity(company);
        return companyEntityMapper.toDomain(
                companyRepository.save(entity)
        );
    }

    @Override
    public Company getCompany(String companyId) {
        return companyEntityMapper.toDomain(
                companyRepository.findById(companyId).orElse(null)
        );
    }

    @Override
    public boolean existsById(String id) {
        return companyRepository.existsById(id);
    }

    @Override
    @Transactional
    public void deleteCompany(String companyId) {
        companyRepository.deleteById(companyId);
    }
}
