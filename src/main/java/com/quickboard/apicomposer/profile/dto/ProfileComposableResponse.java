package com.quickboard.apicomposer.profile.dto;

import com.quickboard.apicomposer.profile.enums.Gender;

import java.time.Instant;
import java.time.LocalDate;

public record ProfileComposableResponse(
        Long id,
        String nickname,
        String firstName,
        String lastName,
        Gender gender,
        LocalDate birthdate,
        Instant createdAt,
        Instant updatedAt
) {}
