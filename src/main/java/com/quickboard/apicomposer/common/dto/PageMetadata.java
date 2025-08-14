package com.quickboard.apicomposer.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PageMetadata(
        long size,
        long totalElements,
        long totalPages,
        long number
) {}
