package com.Itransition.personalHub.CollectionProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CollectionPropertiesController {

    @Autowired
    private CollectionPropertiesServiceImpl mCollectionPropertiesServiceImpl;

    @PutMapping("/collection/properties/update/{id}")
    public void updateProperties(@RequestBody CollectionPropertiesEntity collectionProperties, @PathVariable Long id) {
        mCollectionPropertiesServiceImpl.update(collectionProperties, id);
    }

    @GetMapping("/collection/properties/{id}")
    public CollectionPropertiesEntity getCollectionProperties(@PathVariable Long id) {
        return mCollectionPropertiesServiceImpl.getCollectionPropertiesByCollectionId(id);
    }
}
