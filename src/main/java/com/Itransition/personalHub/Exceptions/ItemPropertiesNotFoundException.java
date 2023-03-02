package com.Itransition.personalHub.Exceptions;

public class ItemPropertiesNotFoundException extends RuntimeException{
    public ItemPropertiesNotFoundException(Long id) {
        super("There are no properties for item with id " + id);
    }
}
