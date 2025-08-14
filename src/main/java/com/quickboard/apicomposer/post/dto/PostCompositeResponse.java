package com.quickboard.apicomposer.post.dto;

import com.quickboard.apicomposer.profile.dto.ProfileComposableResponse;

import java.time.Instant;
import java.util.Objects;

public record PostCompositeResponse(
        Long id,
        String title,
        String content,
        Long boardId,
        Long profileId,
        String profileNickName,
        Long likes,
        Instant createdAt,
        Instant updatedAt
) {
    public static PostCompositeResponse compose(PostComposableResponse post, ProfileComposableResponse profile){
        return new PostCompositeResponse(
                post.id(),
                post.title(),
                post.content(),
                post.boardId(),
                post.profileId(),
                Objects.nonNull(profile) ? profile.nickname() : "unknown",
                post.likes(),
                post.createdAt(),
                post.updatedAt()
        );
    }
}
