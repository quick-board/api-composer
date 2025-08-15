package com.quickboard.apicomposer.post.dto;

import java.time.Instant;

public record PostOriginResponse(
        Long id,
        String title,
        String content,
        Long boardId,
        Long profileId,
        Long likes,
        Instant createdAt,
        Instant updatedAt
) { }
