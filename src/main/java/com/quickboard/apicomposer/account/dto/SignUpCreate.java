package com.quickboard.apicomposer.account.dto;

import com.quickboard.apicomposer.profile.dto.ProfileCreate;

public record SignUpCreate(
    AccountCreate accountCreate,
    ProfileCreate profileCreate
) { }
