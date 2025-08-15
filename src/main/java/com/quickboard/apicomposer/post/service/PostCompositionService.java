package com.quickboard.apicomposer.post.service;

import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.common.enums.Direction;
import com.quickboard.apicomposer.post.dto.PostCompositeResponse;
import com.quickboard.apicomposer.post.dto.PostSearchCondition;

public interface PostCompositionService {
    PagedResponse<PostCompositeResponse> getPostAndProfile(Long boardId, PostSearchCondition postSearchCondition, Long size, String sort, Direction direction);
}
