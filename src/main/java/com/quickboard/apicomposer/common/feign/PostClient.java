package com.quickboard.apicomposer.common.feign;

import com.quickboard.apicomposer.common.dto.PageRequest;
import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.post.dto.PostOriginResponse;
import com.quickboard.apicomposer.post.dto.PostSearchCondition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "resource-post")
public interface PostClient {
    @GetMapping("/rsc/v1/boards/{id}/posts")
    PagedResponse<PostOriginResponse> getAllPosts(@PathVariable("id") Long boardId,
                                                  @SpringQueryMap PostSearchCondition postSearchCondition,
                                                  @SpringQueryMap PageRequest pageRequest);

    @GetMapping("/rsc/v1/posts/{id}")
    PostOriginResponse getPostById(@PathVariable("id") Long postId);
}
