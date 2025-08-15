package com.quickboard.apicomposer.post.controller;

import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.common.enums.Direction;
import com.quickboard.apicomposer.post.dto.PostCompositeResponse;
import com.quickboard.apicomposer.post.dto.PostSearchCondition;
import com.quickboard.apicomposer.post.service.PostCompositionService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/composition/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostCompositionService postCompositionService;

    @GetMapping("/boards/{id}/posts")
    public PagedResponse<PostCompositeResponse> getPostsByBoardId(@PathVariable("id") Long boardId,
                                                                  @ParameterObject @ModelAttribute PostSearchCondition postSearchCondition,
                                                                  @RequestParam(value = "size", required = false) Long size,
                                                                  @RequestParam(value = "sort", required = false) String sort,
                                                                  @RequestParam(value = "direction", required = false) Direction direction){

        return postCompositionService.getPostAndProfile(boardId, postSearchCondition, size, sort, direction);
    }


}
