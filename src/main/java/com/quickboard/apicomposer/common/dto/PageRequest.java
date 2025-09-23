package com.quickboard.apicomposer.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {
    private Long size;
    private Long page;
    private String sort;
}
