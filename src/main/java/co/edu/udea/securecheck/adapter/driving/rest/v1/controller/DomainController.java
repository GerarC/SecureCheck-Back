package co.edu.udea.securecheck.adapter.driving.rest.v1.controller;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.DomainResponse;
import co.edu.udea.securecheck.adapter.driving.rest.v1.service.DomainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Return a domain list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Auditor has been registered successfully",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = DomainResponse.class)))),
    })
    @GetMapping
    public ResponseEntity<List<DomainResponse>> getDomains(){
        return ResponseEntity.ok(domainService.getDomains());
    }
}
