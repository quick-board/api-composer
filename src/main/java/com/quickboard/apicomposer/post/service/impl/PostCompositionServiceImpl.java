package com.quickboard.apicomposer.post.service.impl;

import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.common.feign.client.PostClient;
import com.quickboard.apicomposer.common.feign.client.ProfileClient;
import com.quickboard.apicomposer.post.dto.PostOriginResponse;
import com.quickboard.apicomposer.post.dto.PostCompositeResponse;
import com.quickboard.apicomposer.post.dto.PostSearchCondition;
import com.quickboard.apicomposer.post.service.PostCompositionService;
import com.quickboard.apicomposer.profile.dto.ProfileBulkRequest;
import com.quickboard.apicomposer.profile.dto.ProfileOriginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostCompositionServiceImpl implements PostCompositionService {

    private final PostClient postClient;
    private final ProfileClient profileClient;

    @Override
    public PagedResponse<PostCompositeResponse> getPostsAndProfiles(Long boardId, PostSearchCondition postSearchCondition) {
        PagedResponse<PostOriginResponse> pagedPosts = postClient.getAllPosts(boardId, postSearchCondition);
        List<PostOriginResponse> posts = pagedPosts.content();
        List<Long> distinctProfiles = posts.stream().map(PostOriginResponse::profileId).filter(Objects::nonNull).distinct().toList();
        Map<Long, ProfileOriginResponse> profilesMap = new HashMap<>();

        if(!distinctProfiles.isEmpty()){
            profilesMap.putAll(profileClient.getProfilesByIds(new ProfileBulkRequest(distinctProfiles)).stream()
                    .collect(Collectors.toMap(
                            ProfileOriginResponse::id,
                            Function.identity(),
                            (existing, replacement) -> existing
                    ))
            );
        }

        List<PostCompositeResponse> compositePosts = posts.stream().map(post -> PostCompositeResponse.compose(post, profilesMap.get(post.profileId()))
        ).toList();

        return new PagedResponse<>(compositePosts, pagedPosts.page());
    }

    @Override
    public PostCompositeResponse getPostAndProfile(Long postId) {
        PostOriginResponse post = postClient.getPostById(postId);
        PostCompositeResponse postCompositeResponse;
        if(Objects.nonNull(post.profileId())){
            ProfileOriginResponse profile = profileClient.getProfile(post.profileId());
            postCompositeResponse = PostCompositeResponse.compose(post, profile);
        }
        else {
            postCompositeResponse = PostCompositeResponse.from(post);
        }
        return postCompositeResponse;
    }
}
