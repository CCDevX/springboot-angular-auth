package com.ccdevx.spring_security_auth.repositories;

import com.ccdevx.spring_security_auth.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for the RefreshToken entity.
 * Handles the storage and retrieval of refresh tokens.
 */
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    /**
     * Finds a refresh token by its value.
     * @param token The value of the refresh token.
     * @return An Optional containing the RefreshToken if found, or empty if not.
     */
    Optional<RefreshToken> findByToken(String token);
}
