package com.Itransition.personalHub.CollectionProperties;

import java.time.LocalDateTime;

public interface CollectionPropertiesService {
    void update(CollectionPropertiesEntity collectionProperties, Long collectionId);

    CollectionPropertiesEntity getCollectionProperties(Long collectionId);
}
