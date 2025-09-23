package com.quickboard.apicomposer.post.service;

import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.post.dto.PostCompositeResponse;
import com.quickboard.apicomposer.post.dto.PostSearchCondition;

public interface PostCompositionService {
    PagedResponse<PostCompositeResponse> getPostsAndProfiles(Long boardId, PostSearchCondition postSearchCondition);
    PostCompositeResponse getPostAndProfile(Long postId);
}
