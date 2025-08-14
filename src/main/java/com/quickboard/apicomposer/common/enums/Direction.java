package com.quickboard.apicomposer.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Direction {
    ASC,
    DESC;

    @JsonCreator
    public static Direction fromString(String original){
        return Direction.valueOf(original.toUpperCase());
    }
}
