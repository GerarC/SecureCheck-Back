package co.edu.udea.securecheck.adapter.driving.rest.v1.service;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.DomainResponse;

import java.util.List;

public interface DomainService {
    List<DomainResponse> getDomains();
}
