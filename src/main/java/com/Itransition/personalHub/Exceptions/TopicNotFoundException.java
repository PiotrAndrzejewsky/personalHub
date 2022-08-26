package com.Itransition.personalHub.Exceptions;

public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException (Long id) {
        super("There is no topic with id " + id);
    }
}