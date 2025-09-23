package com.quickboard.apicomposer.post.controller;

import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.post.dto.PostCompositeResponse;
import com.quickboard.apicomposer.post.dto.PostSearchCondition;
import com.quickboard.apicomposer.post.service.PostCompositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/composition/v1")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostCompositionService postCompositionService;

    @GetMapping("/boards/{id}/posts")
    public PagedResponse<PostCompositeResponse> getAllPostsByBoardId(@PathVariable("id") Long boardId,
                                                                  @ParameterObject @ModelAttribute PostSearchCondition postSearchCondition){
        return postCompositionService.getPostsAndProfiles(boardId, postSearchCondition);
    }

    @GetMapping("/boards/{boardId}/posts/{postId}")
    public PostCompositeResponse getPostById(@PathVariable("postId") Long postId){
        return postCompositionService.getPostAndProfile(postId);
    }
}
