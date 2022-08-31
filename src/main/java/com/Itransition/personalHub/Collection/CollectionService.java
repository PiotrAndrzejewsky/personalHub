package com.Itransition.personalHub.Collection;

import java.util.List;

public interface CollectionService {
    boolean createCollection(CollectionEntity collectionEntity);
    void deleteCollection(Long id);
    CollectionEntity getCollection(Long id);
    List<CollectionEntity> getAllCollectionsById(Long userId);
    void updateCollection(CollectionEntity collectionEntity, Long id);
    boolean createNewTopic(String name);

    String getTopicByTopicId(Long id);
    List<String> getAllTopics();
    void updateLikes(Long id, int amount);
    int getLikes(Long id);
}
