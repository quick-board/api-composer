package com.quickboard.apicomposer.comment.dto;

import com.quickboard.apicomposer.comment.enums.CommentStatus;
import com.quickboard.apicomposer.profile.dto.ProfileOriginResponse;

import java.util.Objects;

public record CommentCompositeResponse(
        Long id,
        String content,
        Long likes,
        Long postId,
        Long profileId,
        String profileNickname,
        CommentStatus status
) {
    public static CommentCompositeResponse compose(CommentOriginResponse comment, ProfileOriginResponse profile){
        return new CommentCompositeResponse(
                comment.id(),
                comment.content(),
                comment.likes(),
                comment.postId(),
                comment.profileId(),
                Objects.nonNull(profile) ? profile.nickname() : null,
                comment.status()
        );
    }
}
