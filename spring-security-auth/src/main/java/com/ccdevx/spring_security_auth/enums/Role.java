package com.ccdevx.spring_security_auth.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ccdevx.spring_security_auth.enums.Privilege.*;


/**
 * Enumeration defining user roles and their associated privileges.
 */
@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(READ_PRIVILEGE, WRITE_PRIVILEGE, UPDATE_PRIVILEGE, DELETE_PRIVILEGE)),
    USER(Set.of(READ_PRIVILEGE));

    @Getter
    private final Set<Privilege> privileges;

    /**
     * Generates a list of SimpleGrantedAuthority objects for Spring Security.
     * @return List of authorities associated with the role.
     */
    public List<SimpleGrantedAuthority> getAuthorities() {
        // Converts privileges into SimpleGrantedAuthority objects
        List<SimpleGrantedAuthority> authorities = privileges.stream()
                .map(privilege -> new SimpleGrantedAuthority(privilege.name()))
                .collect(Collectors.toList());

        // Adds the authority corresponding to the role itself (e.g., ROLE_ADMIN)
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}