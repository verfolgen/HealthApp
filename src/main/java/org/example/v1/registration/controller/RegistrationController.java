package org.example.v1.registration.controller;

import lombok.AllArgsConstructor;
import org.example.v1.registration.dto.RegistrationRequest;
import org.example.v1.registration.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam String token) {
        return registrationService.confirmToken(token);
    }
}
