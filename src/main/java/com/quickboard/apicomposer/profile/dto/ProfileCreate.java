package com.quickboard.apicomposer.profile.dto;

import com.quickboard.apicomposer.profile.enums.Gender;

import java.time.LocalDate;

public record ProfileCreate(
        String nickname,
        String firstName,
        String lastName,
        Gender gender,
        LocalDate birthdate
) { }
