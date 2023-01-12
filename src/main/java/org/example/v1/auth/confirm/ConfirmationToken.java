package org.example.v1.auth.confirm;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.v1.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Schema(description = "Entity for store data for confirmation token")
@Data
@NoArgsConstructor
@Entity
@Table(name = "token")
public class ConfirmationToken {
    @Schema(description = "Id of token")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Issued token")
    @Column(name = "token")
    @NotBlank
    private String token;

    @Schema(description = "Created date of the token")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Schema(description = "Expire date of the token")
    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Schema(description = "Confirm date of the token")
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    @Schema(description = "The user associated with the token")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}
