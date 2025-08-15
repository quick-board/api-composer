package com.quickboard.apicomposer.common.dto;


import com.quickboard.apicomposer.common.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {
    private Long size;
    private String sort;
    private Direction direction;
}
