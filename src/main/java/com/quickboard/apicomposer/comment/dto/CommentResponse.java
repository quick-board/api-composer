package com.quickboard.apicomposer.comment.dto;

import com.quickboard.apicomposer.comment.enums.CommentStatus;

public record CommentResponse(
        Long id,
        String content,
        Long likes,
        Long postId,
        Long profileId,
        CommentStatus status
){}
