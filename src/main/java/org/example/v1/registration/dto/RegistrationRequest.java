package org.example.v1.registration.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Schema(description = "DTO for registration request")
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    @Schema(description = "First name for request registration")
    private final String firstName;
    @Schema(description = "Last name for request registration")
    private final String lastName;
    @Schema(description = "Email for request registration")
    private final String email;
    @Schema(description = "Password for request registration")
    private final String password;
}
