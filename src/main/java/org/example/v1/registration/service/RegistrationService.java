package org.example.v1.registration.service;

import lombok.AllArgsConstructor;
import org.example.v1.email.util.EmailValidator;
import org.example.v1.registration.dto.RegistrationRequest;
import org.example.v1.registration.token.ConfirmationToken;
import org.example.v1.registration.token.ConfirmationTokenService;
import org.example.v1.user.entity.User;
import org.example.v1.user.entity.UserRole;
import org.example.v1.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;

    @Transactional
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail) {
            throw new IllegalStateException(request.getEmail() + " is not valid email. Try again");
        }
        return userService.signUp(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.ADMIN
                )
        );
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));


        return "";
    }
}
