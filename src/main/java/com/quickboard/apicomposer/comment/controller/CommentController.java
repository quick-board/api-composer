package com.quickboard.apicomposer.comment.controller;

import com.quickboard.apicomposer.comment.dto.CommentCompositeResponse;
import com.quickboard.apicomposer.comment.service.CommentService;
import com.quickboard.apicomposer.common.dto.PageRequest;
import com.quickboard.apicomposer.common.dto.PagedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/composition/v1")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/posts/{id}/comments")
    public PagedResponse<CommentCompositeResponse> getCommentsByPostId(@PathVariable("id") Long postId,
                                                                       @RequestParam(value = "size", required = false) Long size,
                                                                       @RequestParam(value = "page", defaultValue = "0") Long page,
                                                                       @RequestParam(value = "sort", required = false) String sort){
        return commentService.getCommentsByPostId(postId, new PageRequest(size, page, sort));
    }
}
