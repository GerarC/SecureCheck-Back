package co.edu.udea.securecheck.adapter.driving.rest.v1.service.impl;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.DomainResponse;
import co.edu.udea.securecheck.adapter.driving.rest.v1.mapper.response.DomainResponseMapper;
import co.edu.udea.securecheck.adapter.driving.rest.v1.service.DomainService;
import co.edu.udea.securecheck.domain.api.DomainServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainServiceImpl implements DomainService {
    private final DomainServicePort domainServicePort;
    private final DomainResponseMapper domainResponseMapper;

    @Override
    public List<DomainResponse> getDomains() {
        return domainResponseMapper.toResponses(
                domainServicePort.getDomains()
        );
    }
}
