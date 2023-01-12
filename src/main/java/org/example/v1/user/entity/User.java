package org.example.v1.user.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Collection;
import java.util.Collections;

@Schema(description = "Entity for store user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Schema(description = "Id of user")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "First name of the user")
    @Column(name = "first_name")
    private String firstName;

    @Schema(description = "Last name of the user")
    @Column(name = "last_name")
    private String lastName;

    @Schema(description = "Email of the user")
    @Column(name = "email")
    private String email;

    @Schema(description = "Hash password of the user")
    @Column(name = "password")
    private String password;

    @Schema(description = "Role of the user in the system")
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Schema(description = "Deleted or not user in the system")
    @Column(name = "is_deleted")
    private Boolean is_deleted = false;

    @Schema(description = "Confirm or not user in the system")
    @Column(name = "confirmed")
    private Boolean enabled = false;

    public User(String firstName, String lastName, String email, String password, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
