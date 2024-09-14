package co.edu.udea.securecheck.adapter.driving.rest.controller.v1;

import co.edu.udea.securecheck.adapter.driving.rest.dto.request.SortQueryRequest;
import co.edu.udea.securecheck.adapter.driving.rest.dto.request.filter.CompanyFilterRequest;
import co.edu.udea.securecheck.adapter.driving.rest.dto.response.CompanyResponse;
import co.edu.udea.securecheck.adapter.driving.rest.service.UserService;
import co.edu.udea.securecheck.domain.utils.pagination.PageQuery;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}/companies")
    public ResponseEntity<List<CompanyResponse>> getCompanies(
            @PathVariable String id,
            @Parameter(name = "sort",
                    in = ParameterIn.QUERY,
                    required = true,
                    schema = @Schema(implementation = SortQueryRequest.class),
                    style = ParameterStyle.FORM)
            @Nullable SortQueryRequest sortQueryRequest,
            @Parameter(name = "filter",
                    in = ParameterIn.QUERY,
                    required = true,
                    schema = @Schema(implementation = CompanyFilterRequest.class),
                    style = ParameterStyle.FORM)
            @Nullable CompanyFilterRequest companyFilterRequest) {
        return ResponseEntity.ok(userService.getUserCompanies(id, sortQueryRequest, companyFilterRequest));
    }
}
