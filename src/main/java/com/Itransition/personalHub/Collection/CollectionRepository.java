package com.Itransition.personalHub.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface CollectionRepository extends CrudRepository<CollectionEntity, Long> {
    @Modifying
    @Query(value = "UPDATE collections SET likes = likes + :amount WHERE id = :id", nativeQuery = true)
    void updateLikes(Long id);

    @Query(value = "SELECT * FROM collections WHERE user_id = :id", nativeQuery = true)
    List<CollectionEntity> getAllCollectionsById(Long id);

    @Modifying
    @Query(value = "DELETE FROM collection_properties WHERE collection_id = :id", nativeQuery = true)
    void deletePropertiesById(Long id);

    @Query(value = "SELECT COUNT(id) FROM collection_likes WHERE collection_id = :id", nativeQuery = true)
    int getLikes(Long id);

    @Query(value = "SELECT COUNT(id) FROM collection_likes WHERE collection_id = :collectionId AND user_id = :userId", nativeQuery = true)
    int getLikesByCollectionAndUserId(Long collectionId, Long userId);

    @Modifying
    @Query(value = "INSERT INTO collection_likes (collection_id, user_id) VALUES (:collectionId, :userId)", nativeQuery = true)
    void addNewLike(Long collectionId, Long userId);

    @Modifying
    @Query(value = "DELETE FROM collection_likes WHERE collection_id = :collectionId AND user_id = :userId", nativeQuery = true)
    void deleteLike(Long collectionId, Long userId);

    @Modifying
    @Query(value = "DELETE FROM collection_likes WHERE collection_id = :collectionId", nativeQuery = true)
    void deleteAllCollectionLikes(Long collectionId);
}
