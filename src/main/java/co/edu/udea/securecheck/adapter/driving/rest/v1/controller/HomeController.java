package co.edu.udea.securecheck.adapter.driving.rest.v1.controller;

import co.edu.udea.securecheck.adapter.driving.rest.v1.utils.RestConstants;
import co.edu.udea.securecheck.domain.utils.Generated;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Generated
@RestController
@RequestMapping("/v1")
public class HomeController {
    @Operation(summary = RestConstants.SWAGGER_HOME_END_POINT)
    @GetMapping
    public String home() {
        return "Secure Check";
    }
}
