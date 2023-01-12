package org.example.v1.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "DTO for registration request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @Schema(description = "First name for request registration")
    private String firstName;
    @Schema(description = "Last name for request registration")
    private String lastName;
    @Schema(description = "Email for request registration")
    private String email;
    @Schema(description = "Password for request registration")
    private String password;
}
