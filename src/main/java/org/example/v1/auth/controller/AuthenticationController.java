package org.example.v1.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.example.v1.auth.dto.AuthenticationRequest;
import org.example.v1.auth.dto.AuthenticationResponse;
import org.example.v1.auth.dto.RegistrationRequest;
import org.example.v1.auth.dto.RegistrationResponse;
import org.example.v1.auth.service.AuthenticationService;
import org.example.v1.auth.utils.JwtUtils;
import org.example.v1.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @Operation(summary = "Method for authentication in system")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@Parameter(description = "DTO authentication request")
            @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @Operation(summary = "Method for registration in system and token formation")
    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@Parameter(description = "DTO registration request")
                           @RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @Operation(summary = "Method for confirm account in system")
    @GetMapping("/confirm")
    public String confirm(@Parameter(description = "Token for confirm profile")
                          @RequestParam String token) {
        return authenticationService.confirmToken(token);
    }
}
