package org.example.v1.registration.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.v1.registration.dto.RegistrationRequest;
import org.example.v1.registration.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Registration", description = "All methods for working with registration in the system")
@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @Operation(summary = "Method for registration in system and token formation")
    @PostMapping
    public String register(@Parameter(description = "DTO registration request")
                               @RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @Operation(summary = "Method for confirm account in system")
    @GetMapping("/confirm")
    public String confirm(@Parameter(description = "Token for confirm profile")
                              @RequestParam String token) {
        return registrationService.confirmToken(token);
    }
}
