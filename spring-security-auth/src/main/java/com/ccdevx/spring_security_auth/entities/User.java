package com.ccdevx.spring_security_auth.entities;

import com.ccdevx.spring_security_auth.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Entity representing a user in the security system.
 */
@Builder // Generates a builder for creating instances of the class.
@NoArgsConstructor // Generates a no-arguments constructor.
@AllArgsConstructor // Generates a constructor with all fields as arguments.
@Data // Generates getter, setter, toString, equals, and hashCode methods.
@Entity // Indicates that this class is a JPA entity.
@Table(name = "_user") // Specifies that this entity is mapped to a table named "_user".
public class User implements UserDetails {

    @Id // Defines the primary key for the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // The value of the primary key is automatically generated.
    private Long id;

    private String firstname; // User's first name.
    private String lastname; // User's last name.
    private String email; // User's email address (used as a unique identifier).
    private String password; // User's encrypted password.

    @Enumerated(EnumType.STRING) // Stores the value of the "Role" enum as a string.
    private Role role; // Role assigned to the user.

    /**
     * Returns the authorities (roles and privileges) associated with the user.
     *
     * @return A collection of authorities for the user.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    /**
     * Returns the user's encrypted password.
     *
     * @return The user's password.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the unique identifier for the user (email address in this case).
     *
     * @return The username (email address).
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Indicates whether the user's account is expired.
     *
     * @return true if the account is not expired, false otherwise.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user's account is locked.
     *
     * @return true if the account is not locked, false otherwise.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) are expired.
     *
     * @return true if the credentials are valid, false otherwise.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user's account is enabled.
     *
     * @return true if the account is enabled, false otherwise.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}

