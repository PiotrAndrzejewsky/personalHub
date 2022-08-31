package com.Itransition.personalHub.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface CollectionRepository extends CrudRepository<CollectionEntity, Long> {
    @Query(value = "SELECT * FROM collection_topics WHERE name = :name", nativeQuery = true)
    Optional<Boolean> findTopicByName(String name);

    @Modifying
    @Query(value = "INSERT INTO collection_topics (name) VALUES (:name)", nativeQuery = true)
    void saveNewTopic(String name);

    @Modifying
    @Query(value = "UPDATE collections SET likes = likes + :amount WHERE id = :id", nativeQuery = true)
    void updateLikes(Long id);

    @Query(value = "SELECT name FROM collection_topics WHERE id = :id", nativeQuery = true)
    Optional<String> findTopicById(Long id);

    @Query(value = "SELECT name FROM collection_topics", nativeQuery = true)
    List<String> getAllTopic();

    @Query(value = "SELECT * FROM collections WHERE user_id = :id", nativeQuery = true)
    List<CollectionEntity> getAllCollectionsById(Long id);

    @Modifying
    @Query(value = "DELETE FROM collection_properties WHERE collection_id = :id", nativeQuery = true)
    void deletePropertiesById(Long id);
}
