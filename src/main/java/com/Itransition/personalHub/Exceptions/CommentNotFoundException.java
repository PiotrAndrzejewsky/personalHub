package com.Itransition.personalHub.Exceptions;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(Long commentId) {
        super("There is no comment with id " + commentId);
    }
}
