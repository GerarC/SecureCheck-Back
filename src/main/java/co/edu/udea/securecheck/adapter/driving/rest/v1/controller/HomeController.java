package co.edu.udea.securecheck.adapter.driving.rest.v1.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HomeController {
    @Operation(summary = "Endpoint to test if API is working")
    @GetMapping
    public String home() {
        return "Secure Check";
    }
}
