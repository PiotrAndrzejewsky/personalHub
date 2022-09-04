package com.Itransition.personalHub.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends CrudRepository<TopicEntity, Long> {
    @Query(value = "SELECT * FROM collection_topics", nativeQuery = true)
    List<TopicEntity> getAllTopics();

    @Query(value = "SELECT * FROM collection_topics WHERE name = :name", nativeQuery = true)
    Optional<Boolean> findTopicByName(String name);

}
