package com.Itransition.personalHub.Exceptions;

public class CollectionNotFoundException extends RuntimeException {
    public CollectionNotFoundException (Long id) {
        super("There is no collection with id " + id);
    }
}