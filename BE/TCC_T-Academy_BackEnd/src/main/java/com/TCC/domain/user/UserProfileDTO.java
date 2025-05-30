package com.TCC.domain.user;


public record UserProfileDTO(
        String email,
        String name,
        UserRole role
) {
}
