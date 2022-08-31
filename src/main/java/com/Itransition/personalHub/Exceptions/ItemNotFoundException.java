package com.Itransition.personalHub.Exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Long id) {
        super("There is no item with id " + id);
    }
}
