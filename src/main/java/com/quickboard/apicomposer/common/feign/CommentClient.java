package com.quickboard.apicomposer.common.feign;

import com.quickboard.apicomposer.comment.dto.CommentResponse;
import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.common.enums.Direction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "commentClient", url = "http://resource-comment")
public interface CommentClient {

    @GetMapping("/rsc/v1/posts/{id}/comments")
    PagedResponse<CommentResponse> getCommentsByPostId(@PathVariable("id") Long postId,
                                                       @RequestParam(value = "size", required = false) Long size,
                                                       @RequestParam(value = "sort", required = false) String sort,
                                                       @RequestParam(value = "direction", required = false) Direction direction);

}
