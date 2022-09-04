package com.Itransition.personalHub.Collection;

import java.util.List;

public interface CollectionService {
    boolean createCollection(CollectionEntity collectionEntity);
    void deleteCollection(Long id);
    CollectionEntity getCollection(Long id);
    List<CollectionEntity> getAllCollectionsById(Long userId);
    void updateCollection(CollectionEntity collectionEntity, Long id);
    boolean createNewTopic(TopicEntity topic);

    TopicEntity getTopicByTopicId(Long id);
    List<TopicEntity> getAllTopics();
    void updateLikes(Long collectionId, Long userId);
    int getLikes(Long id);
}
