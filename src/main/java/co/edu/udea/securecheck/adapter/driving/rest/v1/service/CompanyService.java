package co.edu.udea.securecheck.adapter.driving.rest.v1.service;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.request.CompanyRequest;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.CompanyResponse;

public interface CompanyService {
    CompanyResponse createCompany(CompanyRequest companyRequest);
}
