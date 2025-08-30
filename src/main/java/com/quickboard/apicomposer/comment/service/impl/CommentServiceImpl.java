package com.quickboard.apicomposer.comment.service.impl;

import com.quickboard.apicomposer.comment.dto.CommentOriginResponse;
import com.quickboard.apicomposer.comment.dto.CommentCompositeResponse;
import com.quickboard.apicomposer.comment.service.CommentService;
import com.quickboard.apicomposer.common.dto.PageRequest;
import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.common.feign.client.CommentClient;
import com.quickboard.apicomposer.common.feign.client.ProfileClient;
import com.quickboard.apicomposer.profile.dto.ProfileBulkRequest;
import com.quickboard.apicomposer.profile.dto.ProfileOriginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentClient commentClient;
    private final ProfileClient profileClient;

    @Override
    public PagedResponse<CommentCompositeResponse> getCommentsByPostId(Long postId, PageRequest pageRequest) {
        PagedResponse<CommentOriginResponse> pagedComments = commentClient.getCommentsByPostId(postId, pageRequest);
        List<CommentOriginResponse> comments = pagedComments.content();
        List<Long> profileList = comments.stream().map(CommentOriginResponse::profileId).distinct().toList();

        Map<Long, ProfileOriginResponse> profilesMap = profileClient.getProfilesByIds(new ProfileBulkRequest(profileList)).stream()
                .collect(Collectors.toMap(
                        ProfileOriginResponse::id,
                        Function.identity(),
                        (existing, replacement) -> existing
                ));

        List<CommentCompositeResponse> compositeComments = comments.stream()
                .map(comment -> CommentCompositeResponse.compose(comment, profilesMap.get(comment.profileId())))
                .toList();

        return new PagedResponse<>(compositeComments, pagedComments.page());
    }
}
