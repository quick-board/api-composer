package com.quickboard.apicomposer.comment.service;

import com.quickboard.apicomposer.comment.dto.CommentCompositeResponse;
import com.quickboard.apicomposer.common.dto.PageRequest;
import com.quickboard.apicomposer.common.dto.PagedResponse;

public interface CommentService {
    PagedResponse<CommentCompositeResponse> getCommentsByPostId(Long postId, PageRequest pageRequest);
}
