package com.quickboard.apicomposer.board.dto;

import com.quickboard.apicomposer.board.enums.BoardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {
    private Long id;
    private String name;
    private String description;
    private BoardStatus status;
}
