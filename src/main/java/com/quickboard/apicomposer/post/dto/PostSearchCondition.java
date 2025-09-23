package com.quickboard.apicomposer.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PostSearchCondition {
    private Long size;
    private Long page;
    private String sort;
    private String title;
    private String content;
    private Long profileId;
}
