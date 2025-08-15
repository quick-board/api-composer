package com.quickboard.apicomposer.post.service.impl;

import com.quickboard.apicomposer.common.dto.PageRequest;
import com.quickboard.apicomposer.common.enums.Direction;
import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.common.feign.PostClient;
import com.quickboard.apicomposer.common.feign.ProfileClient;
import com.quickboard.apicomposer.post.dto.PostComposableResponse;
import com.quickboard.apicomposer.post.dto.PostCompositeResponse;
import com.quickboard.apicomposer.post.dto.PostSearchCondition;
import com.quickboard.apicomposer.post.service.PostCompositionService;
import com.quickboard.apicomposer.profile.dto.ProfileBulkRequest;
import com.quickboard.apicomposer.profile.dto.ProfileComposableResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostCompositionServiceImpl implements PostCompositionService {

    private final PostClient postClient;
    private final ProfileClient profileClient;

    @Override
    public PagedResponse<PostCompositeResponse> getPostAndProfile(Long boardId, PostSearchCondition postSearchCondition, Long size, String sort, Direction direction) {
        PagedResponse<PostComposableResponse> pagedPosts = postClient.getAllPosts(boardId, postSearchCondition, new PageRequest(size, sort, direction));
        List<PostComposableResponse> posts = pagedPosts.content();
        List<Long> distinctProfiles = posts.stream().map(PostComposableResponse::profileId).distinct().toList();
        Map<Long, ProfileComposableResponse> profilesMap = profileClient.getProfilesByIds(new ProfileBulkRequest(distinctProfiles)).stream()
                .collect(Collectors.toMap(
                        ProfileComposableResponse::id,
                        Function.identity(),
                        (existing, replacement) -> existing
                ));

        List<PostCompositeResponse> compositePosts = posts.stream().map(post -> PostCompositeResponse.compose(post, profilesMap.get(post.profileId()))
        ).toList();

        return new PagedResponse<>(compositePosts, pagedPosts.page());
    }
}
