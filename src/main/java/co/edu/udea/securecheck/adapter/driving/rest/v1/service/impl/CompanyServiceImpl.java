package co.edu.udea.securecheck.adapter.driving.rest.v1.service.impl;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.request.CompanyRequest;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.CompanyResponse;
import co.edu.udea.securecheck.adapter.driving.rest.v1.mapper.request.CompanyRequestMapper;
import co.edu.udea.securecheck.adapter.driving.rest.v1.mapper.response.CompanyResponseMapper;
import co.edu.udea.securecheck.adapter.driving.rest.v1.service.CompanyService;
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
}
