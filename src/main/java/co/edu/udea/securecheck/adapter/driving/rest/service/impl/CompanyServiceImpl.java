package co.edu.udea.securecheck.adapter.driving.rest.service.impl;

import co.edu.udea.securecheck.adapter.driving.rest.dto.request.CompanyRequest;
import co.edu.udea.securecheck.adapter.driving.rest.dto.response.CompanyResponse;
import co.edu.udea.securecheck.adapter.driving.rest.mapper.request.CompanyRequestMapper;
import co.edu.udea.securecheck.adapter.driving.rest.mapper.response.CompanyResponseMapper;
import co.edu.udea.securecheck.adapter.driving.rest.service.CompanyService;
import co.edu.udea.securecheck.domain.api.CompanyServicePort;
import co.edu.udea.securecheck.domain.model.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyServicePort companyServicePort;
    private final CompanyRequestMapper companyRequestMapper;
    private final CompanyResponseMapper companyResponseMapper;

    @Override
    public CompanyResponse createCompany(CompanyRequest companyRequest) {
        Company company = companyRequestMapper.toDomain(companyRequest);
        return companyResponseMapper.toResponse(
                companyServicePort.createCompany(company)
        );
    }

    @Override
    public CompanyResponse getCompany(String companyId) {
        return companyResponseMapper.toResponse(
                companyServicePort.getCompany(companyId)
        );
    }

    @Override
    public CompanyResponse deleteCompany(String companyId) {
        return companyResponseMapper.toResponse(
                companyServicePort.deleteCompany(companyId)
        );
    }
}
