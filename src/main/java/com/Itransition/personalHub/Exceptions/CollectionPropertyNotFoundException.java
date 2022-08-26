package com.Itransition.personalHub.Exceptions;

public class CollectionPropertyNotFoundException extends RuntimeException {
    public CollectionPropertyNotFoundException (Long id) {
        super("There is no collection property with id " + id);
    }
}
