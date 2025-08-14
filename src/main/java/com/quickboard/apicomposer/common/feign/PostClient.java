package com.quickboard.apicomposer.common.feign;

import com.quickboard.apicomposer.common.enums.Direction;
import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.post.dto.PostComposableResponse;
import com.quickboard.apicomposer.post.dto.PostSearchCondition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "postClient", url = "http://resource-post")
public interface PostClient {
    @GetMapping("/rsc/v1/boards/{id}/posts")
    PagedResponse<PostComposableResponse> getAllPosts(@PathVariable("id") Long boardId,
                                                      @ModelAttribute PostSearchCondition postSearchCondition,
                                                      @RequestParam(value = "size", required = false) Long size,
                                                      @RequestParam(value = "sort", required = false) String sort,
                                                      @RequestParam(value = "direction", required = false) Direction direction);

    @GetMapping("/rsc/v1/posts/{id}")
    PostComposableResponse getPostById(@PathVariable("id") Long postId);
}
