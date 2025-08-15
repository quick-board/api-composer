package com.quickboard.apicomposer.post.dto;

import com.quickboard.apicomposer.profile.dto.ProfileOriginResponse;

import java.time.Instant;
import java.util.Objects;

public record PostCompositeResponse(
        Long id,
        String title,
        String content,
        Long boardId,
        Long profileId,
        String profileNickname,
        Long likes,
        Instant createdAt,
        Instant updatedAt
) {
    public static PostCompositeResponse compose(PostOriginResponse post, ProfileOriginResponse profile){
        return new PostCompositeResponse(
                post.id(),
                post.title(),
                post.content(),
                post.boardId(),
                post.profileId(),
                Objects.nonNull(profile) ? profile.nickname() : null,
                post.likes(),
                post.createdAt(),
                post.updatedAt()
        );
    }
}
