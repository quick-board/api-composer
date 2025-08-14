package com.quickboard.apicomposer.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PagedResponse<T>(
        List<T> content,
        PageMetadata page
) { }
