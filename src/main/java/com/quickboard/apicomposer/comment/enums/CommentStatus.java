package com.quickboard.apicomposer.comment.enums;

public enum CommentStatus {
    NORMAL,
    EDITED,
    DELETED,
    REPORTED,
    HIDDEN;

    public static CommentStatus fromString(String original){
        return CommentStatus.valueOf(original.toUpperCase());
    }
}
