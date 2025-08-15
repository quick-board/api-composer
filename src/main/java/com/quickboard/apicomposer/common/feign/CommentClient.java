package com.quickboard.apicomposer.common.feign;

import com.quickboard.apicomposer.comment.dto.CommentOriginResponse;
import com.quickboard.apicomposer.common.dto.PageRequest;
import com.quickboard.apicomposer.common.dto.PagedResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "resource-comment")
public interface CommentClient {

    @GetMapping("/rsc/v1/posts/{id}/comments")
    PagedResponse<CommentOriginResponse> getCommentsByPostId(@PathVariable("id") Long postId,
                                                             @SpringQueryMap PageRequest pageRequest);

}
