package com.Itransition.personalHub.Exceptions;

public class TopicAlreadyExistsException extends RuntimeException{
    public TopicAlreadyExistsException (String name) {
        super("There is already topic with name " + name);
    }
}
