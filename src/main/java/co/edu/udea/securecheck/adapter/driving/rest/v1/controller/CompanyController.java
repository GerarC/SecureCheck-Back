package co.edu.udea.securecheck.adapter.driving.rest.v1.controller;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.request.CompanyRequest;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.CompanyResponse;
import co.edu.udea.securecheck.adapter.driving.rest.v1.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyResponse> createCompany(@RequestBody @Valid CompanyRequest companyRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(companyService.createCompany(companyRequest));
    }

}
