package com.ccdevx.spring_security_auth.repositories;

import com.ccdevx.spring_security_auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for the User entity.
 * Manages database interactions related to users.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their email address.
     * @param email The email address of the user.
     * @return An Optional containing the User if found, or empty if not.
     */
    Optional<User> findByEmail(String email);
}
