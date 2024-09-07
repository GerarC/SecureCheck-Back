package co.edu.udea.securecheck.adapter.driving.rest.v1.controller;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.DomainResponse;
import co.edu.udea.securecheck.adapter.driving.rest.v1.service.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/domains")
@RequiredArgsConstructor
public class DomainController {

    private final DomainService domainService;

    @GetMapping
    public ResponseEntity<List<DomainResponse>> getDomains(){
        return ResponseEntity.ok(domainService.getDomains());
    }
}
