package com.quickboard.apicomposer.profile.dto;

import java.util.List;

public record ProfileBulkRequest(
        List<Long> profileIds
) { }
